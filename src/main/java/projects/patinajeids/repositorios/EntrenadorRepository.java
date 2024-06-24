package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
    
}
