package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

        @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountTransaction at" )
        List<AccountTransactionDto> getAllAccountTransactions();

//        @Query(value = "SELECT " +
//                "       at" +
//                "       FROM " +
//                "       AccountTransaction at" +
//                "       WHERE at.transactionDate = :transactionDate")
//        AccountTransactionDto getTransactionByDate(LocalDate transactionDate);

}

