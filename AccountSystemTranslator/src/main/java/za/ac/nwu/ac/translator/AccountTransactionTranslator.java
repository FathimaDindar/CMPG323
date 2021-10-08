package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.Members;

import java.time.LocalDate;
import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);

    AccountTransactionDto createAdd(AccountTransactionDto accountTransaction);

    AccountTransactionDto createSubtract(AccountTransactionDto accountTransaction);
   }