package projects.patinajeids.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import projects.patinajeids.models.Club;
import projects.patinajeids.models.Entrenador;
import projects.patinajeids.repositorios.ClubRepository;
import projects.patinajeids.repositorios.EntrenadorRepository;



@Controller
@RequestMapping(value = "/clubes")
@SessionAttributes(
    names = { "club" },
    types = { Club.class }
)
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    /* Listado de Clubes Registrados */
    @GetMapping(value = "/listado")
    public String listado(Model model, SessionStatus sessionStatus) {
        if (!sessionStatus.isComplete()) {
            sessionStatus.setComplete();
        }

        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes/listado";
    }

    @GetMapping(value = "/registrar")
    public String formRegister(Club club) {
        return "clubes/crearClub";
    }

    /* Editar Club */
    @GetMapping(value = "/editar/{idClub}")
    public String editar(@PathVariable("idClub") Integer idClub, Model model) {
        Club club = clubRepository.findById(idClub).get();
        model.addAttribute("club", club);
        return "clubes/crearClub";
    }

    /* Registrar un nuevo Club */
    @PostMapping(value = "/registrar")
    public String registrar(@Valid Club club, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()) {
            ra.addFlashAttribute("club", club);
            return "redirect:/clubes/listado";
        }

        List<Entrenador> entrenadores = entrenadorRepository.saveAll(club.getEntrenadores());
        club.setEntrenadores(entrenadores);

        clubRepository.save(club);
        return "redirect:/clubes/listado";
    }

    @RequestMapping(value = "/registrar", params = {"addRow"})
    public String addEntrenador(Club club) {
        club.getEntrenadores().add(new Entrenador());
        return "clubes/crearClub";
    }
    
    @RequestMapping(value = "/registrar", params = {"removeRow"})
    public String removeEntrenador(Club club, HttpServletRequest req) {
        Integer entrenadorId = Integer.valueOf(req.getParameter("removeRow"));
        club.getEntrenadores().remove(entrenadorId.intValue());

        return "clubes/crearClub";
    }    
}
