package projects.patinajeids.controllers;

<<<<<<< HEAD
public class DeportistaController {
    
}
=======
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import projects.patinajeids.models.Deportista;
import projects.patinajeids.repositorios.CategoriaRepository;
import projects.patinajeids.repositorios.ClubRepository;
import projects.patinajeids.repositorios.DeportistaRepository;

@Controller
@RequestMapping(value = "/deportistas")
public class DeportistaController {
    @Autowired
    private DeportistaRepository deportistaRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping(value = "/listado")
    public String listado(Model model) {
        model.addAttribute("deportistas", deportistaRepository.findAll());
        return "deportistas/listado";
    }

    /* Cargar Formulario de Registro de Deportista */
    @GetMapping(value = "/registrar")
    public String registrar(Deportista deportista, Model model) {
        model.addAttribute("deportista", deportista);
        model.addAttribute("clubes", clubRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "deportistas/registrar";
    }

    /* Registrar Neuvo Deportista */
    @PostMapping(value = "/registrar")
    public String registrarDeportista(@Valid Deportista deportista, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()) {
            for (Object error : br.getAllErrors()) {
                System.out.println(error);
            }

            ra.addAttribute("deportista", deportista);
            return "redirect:/deportistas/registrar";
        }

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
>>>>>>> 9c7d67a5bbcc1ecbe13129b735ff8f9a4224ab6d
