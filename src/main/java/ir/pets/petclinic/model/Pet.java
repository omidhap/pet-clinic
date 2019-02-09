package ir.pets.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Pet extends BaseEntity{

    private String petType;
    private Owner owner;
    private LocalDate birthDate;

}
