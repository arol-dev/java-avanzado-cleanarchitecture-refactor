package dev.arol.petclinic.adapter.out.persistence;

import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile({"h2", "postgres"})
public class PetRepositoryAdapter implements PetRepository {

    private final PetRepositoryJpa petRepositoryJpa;

    public PetRepositoryAdapter(PetRepositoryJpa petRepositoryJpa) {
        this.petRepositoryJpa = petRepositoryJpa;
    }

    @Override
    public Pet save(Pet pet) {
        PetJpaEntity entity = PetJpaEntity.fromDomain(pet);
        PetJpaEntity saved = petRepositoryJpa.save(entity);
        return saved.toDomain();
    }

    @Override
    public List<Pet> findAll() {
        return petRepositoryJpa.findAll()
                .stream()
                .map(PetJpaEntity::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(Long petId) {
        return petRepositoryJpa.existsById(petId);
    }


}