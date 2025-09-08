package dev.arol.petclinic.application.port.out;

import dev.arol.petclinic.domain.model.Pet;

import java.util.List;

public interface PetRepository {
    Pet save(Pet pet);

    List<Pet> findAll();

    boolean existsById(Long petId);
}
