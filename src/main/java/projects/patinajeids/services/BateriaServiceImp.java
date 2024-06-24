package projects.patinajeids.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.patinajeids.models.Bateria;
import projects.patinajeids.models.Deportista;
import projects.patinajeids.models.DeportistasHasBaterias;
import projects.patinajeids.models.DeportistasHasBateriasId;
import projects.patinajeids.models.Inscripcion;
import projects.patinajeids.models.Torneo;
import projects.patinajeids.repositorios.BateriaRepository;
import projects.patinajeids.repositorios.DeportistasHasBateriasRepository;
import projects.patinajeids.repositorios.InscripcionRepository;

@Service
public class BateriaServiceImp implements BateriaService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private BateriaRepository bateriaRepository;

    @Autowired
    private DeportistasHasBateriasRepository deportistasHasBateriasRepository;

    public void generarBaterias(Integer torneoId) {
        List<Inscripcion> inscripciones = inscripcionRepository.findByTorneoId(torneoId);
        Map<Integer, List<Deportista>> deportistasPorCategoria = new HashMap<>();

        for (Inscripcion inscripcion : inscripciones) {
            Deportista deportista = inscripcion.getId().getDeportista();
            int categoriaId = deportista.getCategoria().getIdCategoria();
            deportistasPorCategoria.computeIfAbsent(categoriaId, k -> new ArrayList<>()).add(deportista);
        }

        for (List<Deportista> deportistas : deportistasPorCategoria.values()) {
            deportistas.sort(Comparator.comparing(Deportista::getEdad).thenComparing(d -> d.getCategoria().getTipoPatin()));

            int batchSize = 6;
            for (int i = 0; i < deportistas.size(); i += batchSize) {
                Bateria bateria = new Bateria();
                bateria.setTorneo(new Torneo(torneoId));
                Bateria bateriaSaved = bateriaRepository.save(bateria);

                for (int j = i; j < i + batchSize && j < deportistas.size(); j++) {
                    DeportistasHasBaterias dhb = new DeportistasHasBaterias();
                    dhb.setdHasBateriasId(new DeportistasHasBateriasId(deportistas.get(j), bateriaSaved));
                    deportistasHasBateriasRepository.save(dhb);
                }
            }
        }
    }
}