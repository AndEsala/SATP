package projects.patinajeids;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projects.patinajeids.models.Club;
import projects.patinajeids.models.Torneo;
import projects.patinajeids.repositorios.ClubRepository;
import projects.patinajeids.repositorios.TorneoRepository;

@SpringBootTest
public class FinalizarTorneoTest {

    @Autowired
    private TorneoRepository torneoRepository;
    
    @Autowired
    private ClubRepository ClubRepository;

    @Test
    public void testFinalizarTorneo() {
        // Asumimos que existe un torneo con ID 1 en la base de datos
        int idTorneo = 1;

        // Obtenemos el torneo
        Torneo torneo = torneoRepository.findById(idTorneo).orElse(null);
        assertNotNull(torneo, "El torneo debe existir");

        // Simulamos la finalización del torneo
        torneo.setEstado(false);
        
        // Obtenemos el club campeón
        Club clubCampeon = ClubRepository.findByIdChampion(idTorneo).orElse(null);
       

        // Guardamos los cambios
        torneoRepository.save(torneo);

        // Verificamos que el torneo se ha finalizado correctamente
        Torneo torneoActualizado = torneoRepository.findById(idTorneo).orElse(null);
        assertNotNull(torneoActualizado, "El torneo actualizado debe existir");
        assertFalse(torneoActualizado.getEstado(), "El torneo debe estar finalizado");

        // Verificamos que se ha establecido un club campeón
        assertNotNull(clubCampeon, "Debe haber un club campeón");

        // Verificamos que el club campeón tiene puntos
        assertTrue(ClubRepository.getPuntosClub(idTorneo, clubCampeon.getIdClub()) > 0, "El club campeón debe tener puntos");
    }
    
}