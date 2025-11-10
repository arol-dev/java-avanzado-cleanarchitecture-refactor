package dev.arol.petclinic.application.port.in.pet;

import dev.arol.petclinic.domain.model.Pet;

public interface CreatePetUseCase {
    Pet createPet(Pet pet);
}
