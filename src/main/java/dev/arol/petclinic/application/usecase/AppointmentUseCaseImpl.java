// AppointmentUseCaseImpl.java
package dev.arol.petclinic.application.usecase;

import dev.arol.petclinic.application.port.in.*;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAppointmentsUseCase, AppointmentExistsUseCase {

    private final AppointmentRepository appointmentRepository;

    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {

        // Validación para asegurar que el pet existe
        //if (!petRepository.existsById(appointment.getPetId())) {
          //  throw new IllegalArgumentException("Pet with ID " + appointment.getPetId() + " not found");
        //}

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public boolean existsById(Long appointmentId) {
        return appointmentRepository.existsById(appointmentId);
    }
}