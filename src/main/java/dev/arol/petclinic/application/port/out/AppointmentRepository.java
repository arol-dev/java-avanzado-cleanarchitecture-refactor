package dev.arol.petclinic.application.port.out;

import java.util.List;
import java.util.Optional;

import dev.arol.petclinic.domain.model.Appointment;

public interface AppointmentRepository {
	Appointment save(Appointment appointment);
    Optional<Appointment> findById(Long id);
    List<Appointment> findAll();
    boolean existsById(Long id);
    void deleteById(Long id);
    long count();
}
