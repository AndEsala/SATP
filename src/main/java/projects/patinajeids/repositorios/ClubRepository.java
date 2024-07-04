package projects.patinajeids.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.patinajeids.models.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    @Query(value = "SELECT * FROM clubes c WHERE id = clubCampeon(:idTorneo)", nativeQuery = true)
    Optional<Club> findByIdChampion(Integer idTorneo);
    
    @Query(value = "SELECT totalPuntosClub(:idTorneo, :idClub)", nativeQuery = true)
    Integer getPuntosClub(Integer idTorneo, Integer idClub);

    @Query(value = "SELECT * FROM clubes WHERE id IN (SELECT DISTINCT c.id FROM inscripciones i JOIN deportistas d ON i.id_deportista = d.id JOIN clubes c ON i.id_club = c.id WHERE i.id_torneo = :idTorneo)", nativeQuery = true)
    List<Club> getClubesInscritos(Integer idTorneo);

    @Query(value = "SELECT SUM(pago) FROM inscripciones WHERE id_torneo = :idTorneo AND id_club = :idClub", nativeQuery = true)
	Float getTotalPagos(Integer idTorneo, Integer idClub);

    @Query(value = "SELECT COUNT(id_deportista) FROM inscripciones WHERE id_torneo = :idTorneo AND id_club = :idClub", nativeQuery = true)
    Integer getNumeroDeportistasInscritos(Integer idTorneo, Integer idClub);
}
