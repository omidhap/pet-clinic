package ir.pets.petclinic.controllers;

import ir.pets.petclinic.model.Vet;
import ir.pets.petclinic.services.VetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @RequestMapping("/{id}")
    public String vetInfo(@PathVariable("id") Long id, Model model){
        model.addAttribute("vet",vetService.findById(id));
        return "vets/info";
    }

    @GetMapping("/findById")
    public String findById(Model model) {
        model.addAttribute("searchedId", new Vet());
        return "vets/findById";
    }

    @PostMapping("/findById")
    public String findByIdAnswer(@ModelAttribute Vet searchedId) {
        if (!StringUtils.isNumeric(searchedId.getFirstName())) {
            return "redirect:/vets/findById";
        }
        Vet vet = vetService.findById(Long.parseLong(searchedId.getFirstName()));
        if(vet == null){
            return "redirect:/vets/findById";
        }
        return "redirect:/vets/" + vet.getId();
    }
}
