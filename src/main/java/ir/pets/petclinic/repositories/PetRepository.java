package ir.pets.petclinic.repositories;

import ir.pets.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
