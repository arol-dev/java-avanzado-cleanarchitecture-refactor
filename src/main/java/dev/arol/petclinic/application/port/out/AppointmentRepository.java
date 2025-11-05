package dev.arol.petclinic.application.port.out;

import dev.arol.petclinic.domain.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    List<Appointment> findAll();
    Optional<Appointment> findById(Long id);
    boolean existsById(Long id);

}
