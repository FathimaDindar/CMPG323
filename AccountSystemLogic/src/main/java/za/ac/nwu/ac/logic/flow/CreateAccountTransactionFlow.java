package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto createAdd(AccountTransactionDto accountTransaction);

    AccountTransactionDto createSubtract(AccountTransactionDto accountTransaction);
}
