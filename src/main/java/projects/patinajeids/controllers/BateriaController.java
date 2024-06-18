package projects.patinajeids.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.patinajeids.repositorios.BateriaRepository;

@Controller
@RequestMapping("/baterias")
public class BateriaController {
    @Autowired
    private BateriaRepository bateriaRepository;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("baterias", bateriaRepository.findAll());
        return "baterias/listado";
    }
}
