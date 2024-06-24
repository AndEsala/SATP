package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.DeportistasHasBaterias;
import projects.patinajeids.models.DeportistasHasBateriasId;

public interface DeportistasHasBateriasRepository extends JpaRepository<DeportistasHasBaterias, DeportistasHasBateriasId> {
    
}
