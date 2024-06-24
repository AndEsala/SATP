package projects.patinajeids.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.patinajeids.models.Bateria;

public interface BateriaRepository extends JpaRepository<Bateria, Integer> {
    @Query(value = "SELECT * FROM baterias b WHERE id_torneo = :idTorneo", nativeQuery = true)
    List<Bateria> findByTorneo(Integer idTorneo);
}