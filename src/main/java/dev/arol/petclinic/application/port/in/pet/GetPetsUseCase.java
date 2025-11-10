package dev.arol.petclinic.application.port.in.pet;

import dev.arol.petclinic.domain.model.Pet;

import java.util.List;

public interface GetPetsUseCase {
    List<Pet> getAllPets();
}
