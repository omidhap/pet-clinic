package ir.pets.petclinic.repositories;

import ir.pets.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepository extends CrudRepository<Vet, Long> {
}
