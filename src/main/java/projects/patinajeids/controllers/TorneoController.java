package projects.patinajeids.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import projects.patinajeids.models.Competencia;
import projects.patinajeids.models.Deportista;
import projects.patinajeids.models.DeportistasHasBaterias;
import projects.patinajeids.models.Inscripcion;
import projects.patinajeids.models.InscripcionId;
import projects.patinajeids.models.Torneo;
import projects.patinajeids.repositorios.ClubRepository;
import projects.patinajeids.repositorios.CompetenciaRepository;
import projects.patinajeids.repositorios.DeportistaRepository;
import projects.patinajeids.repositorios.DeportistasHasBateriasRepository;
import projects.patinajeids.repositorios.InscripcionRepository;
import projects.patinajeids.repositorios.TorneoRepository;

@Controller
@RequestMapping(value = "/torneos")
@SessionAttributes(
    names = { "torneo" },
    types = { Torneo.class }
)
public class TorneoController {
    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private DeportistaRepository deportistaRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private DeportistasHasBateriasRepository deportistasHasBateriasRepository;

    /* Listado de Torneos */
    @GetMapping(value = "/listado")
    public String listado(Model model, SessionStatus sessionStatus) {
        if (!sessionStatus.isComplete()) {
            sessionStatus.setComplete();
        }

        model.addAttribute("torneos", torneoRepository.findAll());
        return "torneos/listado";
    }

    /* Mostrar formulario para Crear Torneo */
    @GetMapping(value = "/crear")
    public String crear(Torneo torneo, Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "torneos/crearTorneo";
    }

    /* Petición de Creación de Torneo */
    @PostMapping(value = "/crear")
    public String registrarTorneo(@Valid Torneo torneo, BindingResult br, RedirectAttributes ra) {
        if (torneo.getEstado() == null) {
            torneo.setEstado(true);
        }

        if (br.hasErrors()) {
            for (ObjectError oe : br.getAllErrors()) {
                System.out.println(oe.getDefaultMessage());
            }
            ra.addAttribute("torneo", torneo);
            return "redirect:/torneos/crear";
        }

        torneoRepository.save(torneo);
        return "redirect:/torneos/listado";
    }

    /* Mostrar formulario para Editar Torneo */
    @GetMapping(value = "/editar/{idTorneo}")
    public String editar(@PathVariable("idTorneo") Integer idTorneo, Model model) {
        model.addAttribute("torneo", torneoRepository.findById(idTorneo).get());
        model.addAttribute("clubes", clubRepository.findAll());
        return "torneos/crearTorneo";
    }

    /* Administrar un Torneo */
    @GetMapping(value = "/{idTorneo}")
    public String administrarTorneo(@PathVariable("idTorneo") Integer idTorneo, Model model) {
        model.addAttribute("torneo", torneoRepository.findById(idTorneo).get());
        model.addAttribute("competencias", competenciaRepository.findAll());
        return "torneos/dashboard";
    }

    /* Ver Resultados de Baterías en una Competencia de un Torneo */
    @GetMapping(value = "/{idTorneo}/{idCompetencia}")
    public String verResultados(@PathVariable("idTorneo") Integer idTorneo, @PathVariable("idCompetencia") Integer idCompetencia, Model model) {
        Torneo torneo = torneoRepository.findById(idTorneo).get();
        Competencia competencia = competenciaRepository.findById(idCompetencia).get();

        model.addAttribute("torneo", torneo);
        model.addAttribute("competencia", competencia);
        
        List<DeportistasHasBaterias> deportistasHasBaterias = deportistasHasBateriasRepository.findAll();
        Map<Integer, List<DeportistasHasBaterias>> baterias = new HashMap<>();
        
        for (DeportistasHasBaterias dHasBaterias : deportistasHasBaterias) {
            Integer bateriaId = dHasBaterias.getdHasBateriasId().getBateria().getIdBateria();
            
            if (baterias.containsKey(bateriaId)) {
                baterias.get(bateriaId).add(dHasBaterias);
            } else {
                List<DeportistasHasBaterias> deportistas = new ArrayList<>();
                deportistas.add(dHasBaterias);
                
                baterias.put(bateriaId, deportistas);
            }
        }

        model.addAttribute("baterias", baterias);

        return "torneos/verResultados";
    }

    /* Vista de Inscripción de Deportistas a un Torneo */
    @GetMapping(value = "/{idTorneo}/inscripciones")
    public String inscripcion(@PathVariable("idTorneo") Integer idTorneo, Inscripcion inscripcion, Model model) {
        model.addAttribute("torneo", torneoRepository.findById(idTorneo).get());
        return "torneos/inscripciones";
    }

    /* Inscripción de Deportistas a un Torneo */
    @PostMapping(value = "/{idTorneo}/inscripciones")
    public String inscribirDeportista(@PathVariable("idTorneo") Integer idTorneo, @RequestParam("docIdentidad") String docIdentidad, RedirectAttributes ra) {
        Optional<Deportista> deportista = deportistaRepository.findByDocIdentidad(docIdentidad);

        if (!deportista.isPresent()) {
            ra.addFlashAttribute("danger", "Deportista no encontrado.");
            return "redirect:/torneos/" + String.valueOf(idTorneo) + "/inscripciones";
        }

        Deportista deportistaFound = deportista.get();

        if (inscripcionRepository.findByTorneoIdAndDeportistaId(idTorneo, deportistaFound.getIdDeportista()) != null) {
            ra.addFlashAttribute("warning", "Deportista ya inscrito en el torneo.");
            return "redirect:/torneos/" + String.valueOf(idTorneo) + "/inscripciones";
        }

        Integer inscripcionCount = inscripcionRepository.findLastByTorneoId(idTorneo).getNumero();

        Inscripcion inscripcion = new Inscripcion();
        InscripcionId id = new InscripcionId();

        id.setDeportista(deportistaFound);
        id.setClub(deportistaFound.getClub());
        id.setTorneo(torneoRepository.findById(idTorneo).get());
        
        inscripcion.setId(id);
        inscripcion.setFechaInscripcion(new Date());
        inscripcion.setPago(50000);
        inscripcion.setNumero(inscripcionCount + 1);

        inscripcionRepository.save(inscripcion);
        ra.addFlashAttribute("success", "Deportista inscrito exitosamente.");
        return "redirect:/torneos/" + String.valueOf(idTorneo) + "/inscripciones";
    }

    /* Finalizar Torneo */
    @GetMapping(value = "/finalizar/{idTorneo}")
    public String finalizarTorneo(@PathVariable("idTorneo") Integer idTorneo, RedirectAttributes ra) {
        Torneo torneo = torneoRepository.findById(idTorneo).orElse(null);
        
        if (torneo.getEstado() == false) {
            // Torneo already finalized
            ra.addFlashAttribute("mensaje", "El torneo ya está finalizado.");
            return "redirect:/torneos/listado";
        }
        
        torneo.setEstado(false);
        torneoRepository.save(torneo);
        
        ra.addFlashAttribute("mensaje", "Torneo finalizado exitosamente.");
        return "redirect:/torneos/listado";
    }

    /* InitBinder */
    @InitBinder
    public void initBinder(WebDataBinder wdb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
}