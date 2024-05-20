package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.patinajeids.models.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    
}
