package ir.pets.petclinic.controllers;

import ir.pets.petclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/visits")
@Controller
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @RequestMapping
    public String listVisits(Model model) {
        model.addAttribute("visits", visitService.findAll());
        return "visits/index";
    }
}
