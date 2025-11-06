package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAllAppointmentsUseCase;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final GetAllAppointmentsUseCase getAllAppointmentsUseCase;
    private final CreateAppointmentUseCase createAppointmentUseCase;

    @Autowired
    public AppointmentController(GetAllAppointmentsUseCase getAllAppointmentsUseCase,
                                 CreateAppointmentUseCase createAppointmentUseCase) {
        this.getAllAppointmentsUseCase = getAllAppointmentsUseCase;
        this.createAppointmentUseCase = createAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment createdAppointment = createAppointmentUseCase.createAppointment(appointment);
            return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = getAllAppointmentsUseCase.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}