package ir.pets.petclinic.bootstrap;

import ir.pets.petclinic.model.Owner;
import ir.pets.petclinic.model.Pet;
import ir.pets.petclinic.services.OwnerService;
import ir.pets.petclinic.services.PetService;
import ir.pets.petclinic.services.VetService;
import ir.pets.petclinic.services.VisitService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
          PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        if (ownerService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();

        owner1.setFirstName("1");
        owner1.setLastName("1");
        owner1.setAddress("1");
        owner1.setCity("1");
        owner1.setPhoneNumber("1");

        owner2.setFirstName("2");
        owner2.setLastName("2");
        owner2.setAddress("2");
        owner2.setCity("2");
        owner2.setPhoneNumber("2");

        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        pet1.setName("a");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType("a");

        pet2.setName("b");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner1);
        pet2.setPetType("b");

        owner1.getPets().add(pet1);
        owner1.getPets().add(pet2);

        ownerService.save(owner1);
        ownerService.save(owner2);

        petService.save(pet1);
        petService.save(pet2);
    }
}
