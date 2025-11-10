package dev.arol.petclinic.adapter.out.persistence;

import dev.arol.petclinic.adapter.out.persistence.appointment.AppointmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepositoryJpa  extends JpaRepository<AppointmentJpaEntity, Long> {
}
