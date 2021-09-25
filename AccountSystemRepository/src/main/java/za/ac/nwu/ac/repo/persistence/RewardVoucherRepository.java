package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.RewardVoucher;

@Repository
public interface RewardVoucherRepository extends JpaRepository<RewardVoucher, Long> {
}
