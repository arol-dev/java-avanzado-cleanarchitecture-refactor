package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAppointmentsUseCase;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final GetAppointmentsUseCase getAppointmentsUseCase;


    @Autowired
    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase, GetAppointmentsUseCase getAppointmentsUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.getAppointmentsUseCase = getAppointmentsUseCase;
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
        List<Appointment> appointments = getAppointmentsUseCase.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}