package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.AppointmentUseCase;
import dev.arol.petclinic.domain.model.Appointment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentUseCase.CreateAppointmentUseCase createAppointmentUsecase;
    private final AppointmentUseCase.GetAppointmentsUseCase getAppointmentsUseCase;

    public AppointmentController(AppointmentUseCase.CreateAppointmentUseCase createAppointmentUsecase,
                                 AppointmentUseCase.GetAppointmentsUseCase getAppointmentsUseCase) {
        this.createAppointmentUsecase = createAppointmentUsecase;
        this.getAppointmentsUseCase = getAppointmentsUseCase;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment){
        Appointment createdAppointment = createAppointmentUsecase.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = getAppointmentsUseCase.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}
