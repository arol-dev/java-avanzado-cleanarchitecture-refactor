package dev.arol.petclinic.repository;

import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"h2", "postgres"})
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, IAppointmentRepository {
}