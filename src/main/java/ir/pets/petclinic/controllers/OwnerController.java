package ir.pets.petclinic.controllers;

import ir.pets.petclinic.model.Owner;
import ir.pets.petclinic.services.OwnerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/{id}")
    public String ownerInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/info";
    }

    @GetMapping("/findById")
    public String findById(Model model) {
        model.addAttribute("searchedId", new Owner());
        return "owners/findById";
    }

    @PostMapping("/findById")
    public String findByIdAnswer(@ModelAttribute Owner searchedId) {
        if (!StringUtils.isNumeric(searchedId.getFirstName())) {
            return "redirect:/owners/findById";
        }
        Owner owner = ownerService.findById(Long.parseLong(searchedId.getFirstName()));
        if(owner == null){
            return "redirect:/owners/findById";
        }
        return "redirect:/owners/" + owner.getId();
    }
}
