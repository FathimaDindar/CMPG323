package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

@Repository
public interface MilesAccountRepository extends JpaRepository<MilesAccount, Long> {

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       MilesAccount at" +
            "   WHERE at.username = :username")
    MilesAccount getMilesAccountByUsername(String username);

//    @Modifying
//    @Query("update User u set u.status = :status where u.name = :name")
//    int updateUserSetStatusForName(@Param("status") Integer status,
//                                   @Param("name") String name)
    @Modifying
    @Query(value = "UPDATE " +
            "       MilesAccount ma " +
            "   SET ma.miles = ma.miles + :miles " +
            "   WHERE ma.username = :username ")
    int addMilesByUsername(Integer miles, String username);

    @Modifying
    @Query(value = "UPDATE " +
            "       MilesAccount ma " +
            "   SET ma.miles = ma.miles - :miles " +
            "   WHERE ma.username = :username ")
    int subtractMilesByUsername(Integer miles, String username);

}