package projects.patinajeids.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.patinajeids.models.Club;
import projects.patinajeids.repositorios.ClubRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(path = "/clubes")
/* 
 * localhost:8080/clubes
 * GET localhost:8080/clubes
 */
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("")
    public String listadoClubes(Club club, Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes/listado";
    }
}