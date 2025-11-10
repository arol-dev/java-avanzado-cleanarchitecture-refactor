package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.appointment.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.appointment.GetAppointmentUseCase;
import dev.arol.petclinic.domain.model.Appointment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final GetAppointmentUseCase getAppointmentUseCase;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase, GetAppointmentUseCase getAppointmentUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.getAppointmentUseCase = getAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@Valid @RequestBody Appointment appointment) {
        try {
            Appointment createdAppointment = createAppointmentUseCase.createAppointment(appointment.getPetId(), appointment);
            return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = getAppointmentUseCase.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

}
