package dev.arol.petclinic.application.port.in;

import dev.arol.petclinic.domain.model.Pet;

import java.util.List;

public class PetUseCase {
    public interface CreatePetUseCase{
        Pet createPet(Pet pet);
    }
    public interface GetPetsUseCase {
        List<Pet> getAllPets();
    }

    public interface PetExistsUseCase {
        boolean petExists(Long petId);
    }


}
