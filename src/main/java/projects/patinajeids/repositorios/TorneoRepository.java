package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.Torneo;

public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
    
}
