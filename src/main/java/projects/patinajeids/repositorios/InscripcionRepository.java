package projects.patinajeids.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.patinajeids.models.Inscripcion;
import projects.patinajeids.models.InscripcionId;

public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {
    @Query(value = "SELECT * FROM inscripciones WHERE id_torneo = ?1", nativeQuery = true)
    List<Inscripcion> findByTorneoId(Integer idTorneo);

    /* Obtener la última inscripción de un torneo */
    @Query(value = "SELECT * FROM inscripciones WHERE id_torneo = ?1 ORDER BY numero DESC LIMIT 1", nativeQuery = true)
    Inscripcion findLastByTorneoId(Integer idTorneo);

    @Query(value = "SELECT * FROM inscripciones WHERE id_torneo = ?1 AND id_deportista = ?2", nativeQuery = true)
    Inscripcion findByTorneoIdAndDeportistaId(Integer idTorneo, Integer idDeportista);
}
