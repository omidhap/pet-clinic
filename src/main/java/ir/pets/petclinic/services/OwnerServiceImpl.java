package ir.pets.petclinic.services;

import ir.pets.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return null;
    }

    @Override
    public Owner findById(Long aLong) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return null;
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
