package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository repo;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction)
    {
        try{
            return repo.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        List<AccountTransaction> accountTransactions = new ArrayList<>();
        try {
                accountTransactions = new ArrayList<>(repo.findAll());
            } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTransactions;
    }

    @Override
    public AccountTransactionDto createAdd(AccountTransactionDto accountTransaction) {
        return null;
    }


    @Override
    public AccountTransactionDto createSubtract(AccountTransactionDto accountTransaction) {
        return null;
    }


    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionid){
        try{
            return repo.findById(transactionid). orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }



}