package dev.arol.petclinic.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAppointmentsUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Appointment;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAppointmentsUseCase {
	    
	    private final AppointmentRepository appointmentRepository;
	    private final PetRepository petRepository;
	    
	    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository, PetRepository petRepository) {
	        this.appointmentRepository = appointmentRepository;
			this.petRepository = petRepository;
	    }
	    
	    public Appointment createAppointment(Appointment appointment) {
	    	appointment.validateForCreation();

	    	if (!petRepository.existsById(appointment.getPetId())) {
	            throw new IllegalArgumentException("Pet with ID " + appointment.getPetId() + " does not exist");
	        }
	        return appointmentRepository.save(appointment);
	    }
	    
	    @Override
	    public List<Appointment> getAllAppointments() {
	        return appointmentRepository.findAll();
	    }
}
