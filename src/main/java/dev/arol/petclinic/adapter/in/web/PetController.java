package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.pet.CreatePetUseCase;
import dev.arol.petclinic.application.port.in.pet.GetPetsUseCase;
import dev.arol.petclinic.domain.model.Pet;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final CreatePetUseCase createPetUseCase;
    private final GetPetsUseCase getPetsUseCase;

    public PetController(CreatePetUseCase createPetUseCase,
                         GetPetsUseCase getPetsUseCase) {
        this.createPetUseCase = createPetUseCase;
        this.getPetsUseCase = getPetsUseCase;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        Pet createdPet = createPetUseCase.createPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = getPetsUseCase.getAllPets();
        return ResponseEntity.ok(pets);
    }
}
