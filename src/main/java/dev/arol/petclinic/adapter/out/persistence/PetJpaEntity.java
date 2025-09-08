package dev.arol.petclinic.adapter.out.persistence;

import dev.arol.petclinic.domain.model.Pet;
import jakarta.persistence.*;

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

    public PetJpaEntity(Long id, String name, String species, String ownerName) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.ownerName = ownerName;
    }

    public PetJpaEntity() {

    }

    // Método para convertir a entidad de dominio
    public Pet toDomain() {
        return new Pet(id, name, species, ownerName);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Método para crear desde entidad de dominio
    public static PetJpaEntity fromDomain(Pet pet) {
        return new PetJpaEntity(pet.getId(), pet.getName(), pet.getSpecies(), pet.getOwnerName());
    }
}