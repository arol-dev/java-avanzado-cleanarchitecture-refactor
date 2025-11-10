package dev.arol.petclinic.application.port.in.appointment;

import dev.arol.petclinic.domain.model.Appointment;

public interface CreateAppointmentUseCase {
    Appointment createAppointment(Long petId, Appointment appointment);
}

