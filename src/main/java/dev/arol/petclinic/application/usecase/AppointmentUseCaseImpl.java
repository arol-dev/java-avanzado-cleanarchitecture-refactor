package dev.arol.petclinic.application.usecase;

import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAppointmentsUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAppointmentsUseCase {

    private final AppointmentRepository appointmentRepository;
    private final PetUseCaseImpl petUseCase;

    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository, PetUseCaseImpl petUseCase){
        this.appointmentRepository = appointmentRepository;
        this.petUseCase = petUseCase;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        if (!petUseCase.petExists(appointment.getPetId())) {
            throw new IllegalArgumentException("Pet with ID " + appointment.getPetId() + " does not exist");
        }
        appointment.validateForCreation();
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return this.appointmentRepository.findAll();
    }
}
