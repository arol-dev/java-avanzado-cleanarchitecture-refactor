package dev.arol.petclinic.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Pet;

/**
 * (Adaptador)
 */
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

    // ... otros métodos
	@Override
	public Optional<Pet> findById(Long id) {
		return petRepositoryJpa.findById(id).stream().map(PetJpaEntity::toDomain).findFirst();
	}

	@Override
	public boolean existsById(Long id) {
		return petRepositoryJpa.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		petRepositoryJpa.deleteById(id);		
	}

	@Override
	public long count() {
		return petRepositoryJpa.count();
	}
    
}