package dev.arol.petclinic.application.port.in;

public interface AppointmentExistsUseCase {
    boolean existsById(Long appointmentId);
}
