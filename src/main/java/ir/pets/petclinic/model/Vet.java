package ir.pets.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Vet extends Person {

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private Set<Visit> visits = new HashSet<>();
}
