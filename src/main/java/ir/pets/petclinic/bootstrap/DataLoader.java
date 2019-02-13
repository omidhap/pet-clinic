package ir.pets.petclinic.bootstrap;

import ir.pets.petclinic.model.Owner;
import ir.pets.petclinic.model.Pet;
import ir.pets.petclinic.model.Vet;
import ir.pets.petclinic.model.Visit;
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

        owner1.setFirstName("ali");
        owner1.setLastName("azimi");
        owner1.setAddress("jomhoori");
        owner1.setCity("tehran");
        owner1.setPhoneNumber("09152345345");

        owner2.setFirstName("amir");
        owner2.setLastName("rezayi");
        owner2.setAddress("jannat");
        owner2.setCity("tehran");
        owner2.setPhoneNumber("09376546797");

        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        pet1.setName("jj");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType("dog");

        pet2.setName("luna");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner1);
        pet2.setPetType("cat");

        owner1.getPets().add(pet1);
        owner1.getPets().add(pet2);

        ownerService.save(owner1);
        ownerService.save(owner2);

        petService.save(pet1);
        petService.save(pet2);

        Vet vet = new Vet();

        vet.setFirstName("dr");
        vet.setLastName("jam");
        vet.setPhoneNumber("09123453675");

        Visit visit = new Visit();

        visit.setDate(LocalDate.now());
        visit.setDescription("check up");
        visit.setPet(pet1);
        visit.setVet(vet);

        pet1.getVisits().add(visit);
        vet.getVisits().add(visit);

        vetService.save(vet);

        visitService.save(visit);
    }
}
