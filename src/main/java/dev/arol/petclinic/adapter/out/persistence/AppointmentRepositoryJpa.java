package dev.arol.petclinic.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * (Repositorio Spring Data)
 */
public interface AppointmentRepositoryJpa extends JpaRepository<AppointmentJpaEntity, Long> {
}