package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

@Repository
public interface MilesAccountRepository extends JpaRepository<MilesAccount, Long> {
}