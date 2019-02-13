package ir.pets.petclinic.controllers;

import ir.pets.petclinic.model.Visit;
import ir.pets.petclinic.services.VisitService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/{id}")
    public String visitInfo(@PathVariable("id") Long id, Model model){
        model.addAttribute("visit",visitService.findById(id));
        return "visits/info";
    }

    @GetMapping("/findById")
    public String findById(Model model) {
        model.addAttribute("searchedId", new Visit());
        return "visits/findById";
    }

    @PostMapping("/findById")
    public String findByIdAnswer(@ModelAttribute Visit searchedId) {
        if (!StringUtils.isNumeric(searchedId.getDescription())) {
            return "redirect:/visits/findById";
        }
        Visit visit = visitService.findById(Long.parseLong(searchedId.getDescription()));
        if(visit == null){
            return "redirect:/visits/findById";
        }
        return "redirect:/visits/" + visit.getId();
    }
}
