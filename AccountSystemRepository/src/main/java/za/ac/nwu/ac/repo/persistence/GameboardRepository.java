package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Gameboard;

@Repository
public interface GameboardRepository extends JpaRepository<Gameboard, Long> {
}
