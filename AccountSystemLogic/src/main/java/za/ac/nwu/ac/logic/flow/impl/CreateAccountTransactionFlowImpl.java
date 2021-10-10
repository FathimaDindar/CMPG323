package za.ac.nwu.ac.logic.flow.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.*;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final FetchMembersFlow fetchMembersFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow,
                                            FetchMembersFlow fetchMembersFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.fetchMembersFlow = fetchMembersFlow;

    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        if (LOGGER.isInfoEnabled()){
            if(null != accountTransactionDto){
                LOGGER.info("The input object was {} ", accountTransactionDto);
            }
        }


        accountTransactionDto.setTransactionDate(LocalDate.now());

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic((
                accountTransactionDto.getAccountTypeMnemonic()));
        LOGGER.info("Got AccountType for {} ", accountTransactionDto.getAccountTypeMnemonic());
        Members member = fetchMembersFlow.getMembersDbByUsername((accountTransactionDto.getUsername()));
        LOGGER.info("Got Member for {}", accountTransactionDto.getUsername());

        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType,member);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if ((Objects.equals(accountTransaction.getDetails(), "add") && (Objects.equals(accountType.getMnemonic(), member.getAccountType().getMnemonic()))))
        {
            accountTransaction.setDetails("An amount of " + String.valueOf(accountTransaction.getAmount()) + " has been added to the account." );
            member.setBalance(member.getBalance() + accountTransaction.getAmount());
        }
        else if (Objects.equals(accountTransaction.getDetails(), "subtract") && (Objects.equals(accountType.getMnemonic(), member.getAccountType().getMnemonic())))
        {
            accountTransaction.setDetails("An amount of " + String.valueOf(accountTransaction.getAmount()) + " has been subtracted from the account." );
            member.setBalance(member.getBalance() - accountTransaction.getAmount());
        }
        else if (!Objects.equals(accountType.getMnemonic(), member.getAccountType().getMnemonic()))
        {
            accountTransaction.setDetails("No amount was added or subtracted. Incompatible Username and Account Type");
        }

        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
        LOGGER.info("The return object id {}", results);
        return results;
    }
}