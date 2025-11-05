package dev.arol.petclinic.application.usecase;

import dev.arol.petclinic.application.port.in.AppointmentUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentUseCaseImpl implements AppointmentUseCase.CreateAppointmentUseCase, AppointmentUseCase.GetAppointmentsUseCase, AppointmentUseCase.AppointmentExistsUseCase {

    private final AppointmentRepository appointmentRepository;

    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointment.validateAppointment();
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public boolean appointmentExists(Long appointmentId) {
        return appointmentRepository.existsById(appointmentId);
    }
}
