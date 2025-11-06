package dev.arol.petclinic.application.port.out;

import java.util.List;

import dev.arol.petclinic.domain.model.Appointment;

public interface AppointmentRepository {
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
}
