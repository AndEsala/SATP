package projects.patinajeids.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import projects.patinajeids.models.Competencia;
import projects.patinajeids.models.Inscripcion;
import projects.patinajeids.models.Torneo;
import projects.patinajeids.repositorios.BateriaRepository;
import projects.patinajeids.repositorios.CompetenciaRepository;
import projects.patinajeids.repositorios.TorneoRepository;

@Controller
@RequestMapping(value = "/torneos")
public class TorneoController {
    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private BateriaRepository bateriaRepository;

    /* Listado de Torneos */
    @GetMapping(value = "/listado")
    public String listado(Model model) {
        model.addAttribute("torneos", torneoRepository.findAll());
        return "torneos/listado";
    }

    /* Mostrar formulario para Crear Torneo */
    @GetMapping(value = "/crear")
    public String crear(Torneo torneo) {
        return "torneos/crearTorneo";
    }

    /* Petición de Creación de Torneo */
    @PostMapping(value = "/crear")
    public String registrarTorneo(@Valid Torneo torneo, BindingResult br, RedirectAttributes ra) {
        torneo.setEstado(true);

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
        model.addAttribute("baterias", bateriaRepository.findByTorneo(idTorneo));
        return "torneos/verResultados";
    }

    /* Vista de Inscripción de Deportistas a un Torneo */
    @GetMapping(value = "/{idTorneo}/inscripciones")
    public String inscripcion(@PathVariable("idTorneo") Integer idTorneo, Inscripcion inscripcion, Model model) {
        model.addAttribute("torneo", torneoRepository.findById(idTorneo).get());
        return "torneos/inscripciones";
    }

    /* InitBinder */
    @InitBinder
    public void initBinder(WebDataBinder wdb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
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
    
    

}