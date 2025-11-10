package dev.arol.petclinic.application.usecase;

import dev.arol.petclinic.application.port.in.appointment.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.appointment.GetAppointmentUseCase;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.application.port.out.PetRepository;
import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AppointmentUseCaseImpl implements CreateAppointmentUseCase, GetAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;
    private final PetRepository petRepository;

    public AppointmentUseCaseImpl(AppointmentRepository appointmentRepository, PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Appointment createAppointment(Long petId, Appointment appointment) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (pet.isEmpty()) {
            throw new NoSuchElementException("Pet not found");
        }
        appointment.setPetId(pet.get().getId());
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
