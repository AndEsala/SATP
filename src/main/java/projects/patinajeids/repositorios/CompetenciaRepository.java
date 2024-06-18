package projects.patinajeids.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.Competencia;

public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {
    
}
