package projects.patinajeids.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import projects.patinajeids.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{ 
    
}
