package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.persistence.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       Members at" +
            "   WHERE at.username = :username")
    MembersDto getMembersByUsername(String username);

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       Members at" +
            "   WHERE at.username = :username ")
    Members getMembersDbByUsername(String username);

}
