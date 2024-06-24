package projects.patinajeids.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.patinajeids.models.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    @Query(value = "SELECT * FROM clubes c WHERE id = clubCampeon(:idTorneo)", nativeQuery = true)
    Optional<Club> findByIdChampion(Integer idTorneo);
    
    @Query(value = "SELECT TotalPuntosClub(:idTorneo, :idClub)", nativeQuery = true)
    Integer GetPuntosClub(Integer idTorneo, Integer idClub);

}
