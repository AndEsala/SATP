package projects.patinajeids.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projects.patinajeids.models.DeportistasHasBaterias;
import projects.patinajeids.repositorios.DeportistasHasBateriasRepository;
import projects.patinajeids.services.BateriaService;

@Controller
@RequestMapping("/baterias")
public class BateriaController {
    @Autowired
    private BateriaService bateriaService;

    @Autowired
    private DeportistasHasBateriasRepository deportistasHasBateriasRepository;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<DeportistasHasBaterias> deportistasHasBaterias = deportistasHasBateriasRepository.findAll();
        Map<Integer, List<DeportistasHasBaterias>> baterias = new HashMap<>();
        
        for (DeportistasHasBaterias dHasBaterias : deportistasHasBaterias) {
            int bateriaId = dHasBaterias.getdHasBateriasId().getBateria().getIdBateria();
            if (!baterias.containsKey(bateriaId)) {
                baterias.put(bateriaId, List.of(dHasBaterias));
            } else {
                baterias.get(bateriaId).add(dHasBaterias);
            }
        }

        model.addAttribute("baterias", baterias);
        return "baterias/listado";
    }

    @GetMapping("/generar/{idTorneo}")
    public String generarBaterias(@PathVariable Integer idTorneo, RedirectAttributes attr) {
        bateriaService.generarBaterias(idTorneo);
        attr.addFlashAttribute("success", "Baterías generadas correctamente");
        return "redirect:/torneos/" + String.valueOf(idTorneo);
    }
}
