package projects.patinajeids;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projects.patinajeids.models.Bateria;
import projects.patinajeids.models.DeportistasHasBaterias;
import projects.patinajeids.repositorios.BateriaRepository;
import projects.patinajeids.repositorios.DeportistasHasBateriasRepository;
import projects.patinajeids.services.BateriaService;

@SpringBootTest
public class BateriaServiceTest {
    @Autowired
    private BateriaService bateriaService;

    @Autowired
    private BateriaRepository bateriaRepository;

    @Autowired
    private DeportistasHasBateriasRepository deportistasHasBateriasRepository;

    @Test
    public void testOrganizarBaterias() {
        // Llama al método que organiza las baterías
        bateriaService.generarBaterias(1);

        // Verifica que las baterías se han creado correctamente
        List<Bateria> baterias = bateriaRepository.findAll();
        assertNotNull(baterias);
        List<DeportistasHasBaterias> deportistasHasBaterias = deportistasHasBateriasRepository.findAll();

        // Verifica que las baterías están organizadas como esperas
        for (int i = 0; i < baterias.size(); i++) {
            Bateria bateria = baterias.get(i);
            List<DeportistasHasBaterias> dhbFilter = deportistasHasBaterias.stream().filter((dhb) -> dhb.getdHasBateriasId().getBateria().getIdBateria() == bateria.getIdBateria()).toList();
            Assertions.assertThat(dhbFilter.size()).isLessThan(7);
        }
    }
}
