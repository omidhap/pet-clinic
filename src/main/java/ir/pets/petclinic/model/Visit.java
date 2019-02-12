package ir.pets.petclinic.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Visit extends AbstractBaseEntity {

    private LocalDate date;
    private String description;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Vet vet;
}
