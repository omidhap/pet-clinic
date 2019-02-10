package ir.pets.petclinic.repositories;


import ir.pets.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;


public interface VisitRepository extends CrudRepository<Visit, Long> {

}
