package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.Deportista;

public interface DeportistaRepository extends JpaRepository<Deportista, Integer> {
    
}