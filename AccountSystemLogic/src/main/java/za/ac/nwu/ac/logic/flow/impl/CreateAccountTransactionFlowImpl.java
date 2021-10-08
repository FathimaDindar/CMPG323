package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.persistence.*;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;
import za.ac.nwu.ac.translator.AccountTransactionDetailsTranslator;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final FetchMembersFlow fetchMembersFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            AccountTransactionDetailsTranslator accountTransactionDetailsTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow,
                                            FetchMembersFlow fetchMembersFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.fetchMembersFlow = fetchMembersFlow;

    }

    @Override
    public AccountTransactionDto createAdd(AccountTransactionDto accountTransactionDto){
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic((
                accountTransactionDto.getAccountTypeMnemonic()));
        Members member = fetchMembersFlow.getMembersByUsername((accountTransactionDto.getUsername()));
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType,member);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if(null != accountTransactionDto.getDetails()){
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }

        member.setMiles(member.getMiles() + accountTransaction.getAmount());

        return new AccountTransactionDto(accountTransaction);
    }

    @Override
    public AccountTransactionDto createSubtract(AccountTransactionDto accountTransactionDto){
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic((
                accountTransactionDto.getAccountTypeMnemonic()));
        Members member = fetchMembersFlow.getMembersByUsername((accountTransactionDto.getUsername()));
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType,member);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if(null != accountTransactionDto.getDetails()){
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }

        member.setMiles(member.getMiles() - accountTransaction.getAmount());

        return new AccountTransactionDto(accountTransaction);
    }
}