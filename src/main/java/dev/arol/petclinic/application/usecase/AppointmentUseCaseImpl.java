package dev.arol.petclinic.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.arol.petclinic.application.port.in.PetExistsUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAllAppointmentsUseCase;
import dev.arol.petclinic.domain.model.Appointment;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAllAppointmentsUseCase{

    @Autowired PetExistsUseCase petExistsUseCase;
    @Autowired AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    @Override
    public Appointment createAppointment(Appointment appointment) {
        if (!petExistsUseCase.petExists(appointment.getPetId())) {
            throw new IllegalArgumentException("Pet with ID " + appointment.getPetId() + " does not exist");
        }
        return appointmentRepository.save(appointment);
    }
    
}
