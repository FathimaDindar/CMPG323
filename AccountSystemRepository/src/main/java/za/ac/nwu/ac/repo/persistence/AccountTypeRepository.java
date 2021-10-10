package za.ac.nwu.ac.repo.persistence;

import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import javax.persistence.PostUpdate;
import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {


    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeDbByMnemonic(String mnemonic);

//    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
//            "       at.mnemonic," +
//            "       at.accountTypeName, " +
//            "       at.creationDate )" +
//            "   FROM " +
//            "       AccountType at" +
//            "   WHERE at.mnemonic = :mnemonic ")
//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
//
//    @Query(value = "SELECT "+
////            "       ACCOUNT_TYPE_ID," +
////            "       ACCOUNT_TYPE_NAME," +
////            "       CREATION_DATE," +
////            "       MNEMONIC" +
////            "   FROM" +
////            "       FATHIMA.ACCOUNT_TYPE "+
////            "   WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
////    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
//
//    @Modifying
//    @Query(value = "UPDATE" +
//            "         AccountType at" +
//            "   SET at.accountTypeName = :accountTypeName, at.creationDate = :creationDate" +
//            "   WHERE at.mnemonic = :mnemonic")
//    int updateAccountType(String mnemonic, String accountTypeName, LocalDate creationDate);



}
