package projects.patinajeids.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projects.patinajeids.repositorios.BateriaRepository;
import projects.patinajeids.services.BateriaService;

@Controller
@RequestMapping("/baterias")
public class BateriaController {
    @Autowired
    private BateriaRepository bateriaRepository;

    @Autowired
    private BateriaService bateriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("baterias", bateriaRepository.findAll());
        return "baterias/listado";
    }

    @PostMapping("/generar")
    public ResponseEntity<?> generarBaterias(@RequestParam int torneoId) {
        bateriaService.generarBaterias(torneoId);
        return ResponseEntity.ok("Baterías generadas correctamente");
    }
}
