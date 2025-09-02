package dev.arol.petclinic.application.port.out;

import java.util.List;
import java.util.Optional;

import dev.arol.petclinic.domain.model.Pet;

public interface PetRepository {
	Pet save(Pet pet);
    Optional<Pet> findById(Long id);
    List<Pet> findAll();
    boolean existsById(Long id);
    
    //No estaban incluidos en el readme
    void deleteById(Long id);
    long count();
}
