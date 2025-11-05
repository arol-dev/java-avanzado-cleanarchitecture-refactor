package dev.arol.petclinic.application.usecase;

import dev.arol.petclinic.application.port.in.PetUseCase;
import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetUseCaseImpl implements PetUseCase.CreatePetUseCase, PetUseCase.GetPetsUseCase, PetUseCase.PetExistsUseCase {

    private final PetRepository petRepository;
    public PetUseCaseImpl(PetRepository petRepository){
        this.petRepository = petRepository;
    }
    @Override
    public Pet createPet(Pet pet) {
        pet.validateForCreation();
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public boolean petExists(Long petId) {
        return petRepository.existsById(petId);
    }
}
