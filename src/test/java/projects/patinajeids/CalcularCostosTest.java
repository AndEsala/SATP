package projects.patinajeids;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projects.patinajeids.models.Club;
import projects.patinajeids.repositorios.ClubRepository;

@SpringBootTest
public class CalcularCostosTest {
    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void testCalcularCostos() {
        int idTorneo = 1;
        Map<Club, Float> costos = new HashMap<>();
        Map<Club, Integer> nDeportistas = new HashMap<>();

        // Obtenemos los clubes registrados en el torneo
        List<Club> clubes = clubRepository.getClubesInscritos(idTorneo);
        for (Club club : clubes) {
            costos.put(club, clubRepository.getTotalPagos(idTorneo, club.getIdClub()));
            nDeportistas.put(club, clubRepository.getNumeroDeportistasInscritos(idTorneo, club.getIdClub()));
        }
        
        costos.forEach((club, totalPagos) -> {
            Assertions.assertThat(totalPagos).isGreaterThan(0);
            assertEquals(totalPagos, nDeportistas.get(club) * 50000);
        });
    }
}