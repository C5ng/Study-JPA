package c5ng.data_jpa.repository;

import c5ng.data_jpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
