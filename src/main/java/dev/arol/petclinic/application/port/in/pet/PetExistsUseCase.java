package dev.arol.petclinic.application.port.in.pet;

public interface PetExistsUseCase {
    boolean petExists(Long petId);
}
