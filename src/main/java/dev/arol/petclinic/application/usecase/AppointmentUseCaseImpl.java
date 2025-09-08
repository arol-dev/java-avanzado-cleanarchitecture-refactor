package dev.arol.petclinic.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.arol.petclinic.application.port.in.AppointmentExistsUseCase;
import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.CreatePetUseCase;
import dev.arol.petclinic.application.port.in.GetAppointmentsUseCase;
import dev.arol.petclinic.application.port.in.GetPetsUseCase;
import dev.arol.petclinic.application.port.in.PetExistsUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAppointmentsUseCase, AppointmentExistsUseCase {

    private final AppointmentRepository appointmentRepository;

    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointment.validateForCreation(); // Lógica de dominio
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public boolean appointmentExists(Long petId) {
        return appointmentRepository.existsById(petId);
    }
}
