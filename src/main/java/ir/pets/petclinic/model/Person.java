package ir.pets.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
