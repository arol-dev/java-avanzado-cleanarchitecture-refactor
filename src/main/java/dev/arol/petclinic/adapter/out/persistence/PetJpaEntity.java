package dev.arol.petclinic.adapter.out.persistence;

import dev.arol.petclinic.domain.model.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class PetJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    // Constructores, getters, setters
    public PetJpaEntity() {}

    public PetJpaEntity(Long id, String name, String species, String ownerName) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.ownerName = ownerName;
    }

    // Método para convertir a entidad de dominio
    public Pet toDomain() {
        return new Pet(id, name, species, ownerName);
    }

    // Método para crear desde entidad de dominio
    public static PetJpaEntity fromDomain(Pet pet) {
        return new PetJpaEntity(pet.getId(), pet.getName(),
                pet.getSpecies(), pet.getOwnerName());
    }
}
