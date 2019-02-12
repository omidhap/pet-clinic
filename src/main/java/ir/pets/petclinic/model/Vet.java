package ir.pets.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Vet extends Person {

    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private Set<Visit> visits = new HashSet<>();
}
