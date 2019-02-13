package ir.pets.petclinic.controllers;

import ir.pets.petclinic.model.Pet;
import ir.pets.petclinic.services.PetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pets")
@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping
    public String listPets(Model model) {
        model.addAttribute("pets", petService.findAll());
        return "pets/index";
    }

    @RequestMapping("/{id}")
    public String petInfo(@PathVariable("id") Long id, Model model){
        model.addAttribute("pet",petService.findById(id));
        return "pets/info";
    }

    @GetMapping("/findById")
    public String findById(Model model) {
        model.addAttribute("searchedId", new Pet());
        return "pets/findById";
    }

    @PostMapping("/findById")
    public String findByIdAnswer(@ModelAttribute Pet searchedId) {
        if (!StringUtils.isNumeric(searchedId.getName())) {
            return "redirect:/pets/findById";
        }
        Pet pet = petService.findById(Long.parseLong(searchedId.getName()));
        if(pet == null){
            return "redirect:/pets/findById";
        }
        return "redirect:/pets/" + pet.getId();
    }
}
