package ir.pets.petclinic.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@MappedSuperclass
public class Person extends AbstractBaseEntity {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;
}
