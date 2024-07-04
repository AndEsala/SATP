package projects.patinajeids.repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import projects.patinajeids.models.Deportista;

public interface DeportistaRepository extends JpaRepository<Deportista, Integer> {
    Optional<Deportista> findByDocIdentidad(String docIdentidad);
}