package dev.arol.petclinic.application.port.in;

import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;

import java.util.List;

public class AppointmentUseCase {
    public interface CreateAppointmentUseCase{
        Appointment createAppointment(Appointment appointment);
    }
    public interface GetAppointmentsUseCase {
        List<Appointment> getAllAppointments();
    }

    public interface AppointmentExistsUseCase {
        boolean appointmentExists(Long appointmentId);
    }
}
