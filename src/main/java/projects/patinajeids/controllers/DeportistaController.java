package projects.patinajeids.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.patinajeids.models.Deportista;
import projects.patinajeids.repositorios.CategoriaRepository;
import projects.patinajeids.repositorios.ClubRepository;
import projects.patinajeids.repositorios.DeportistaRepository;

@Controller
@RequestMapping(path = "/deportistas")
public class DeportistaController {

    @Autowired
    private DeportistaRepository deportistaRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/listado")
    public String mostrarDeportistas(Model model) {
        model.addAttribute("deportistas", deportistaRepository.findAll());
        return "deportistas/listado";
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model, Deportista deportista) {
        model.addAttribute("deportista", new Deportista());
        model.addAttribute("clubes", clubRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "deportistas/registro";
    }

    @PostMapping("/registro1")
    public String registrarDeportista(Deportista deportista) {
        deportistaRepository.save(deportista);
        return "redirect:/deportistas/listado";
    }

    /* InitBinder */
    @InitBinder
    public void initBinder(WebDataBinder wdb) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
}

