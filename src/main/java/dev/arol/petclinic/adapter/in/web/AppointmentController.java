package dev.arol.petclinic.adapter.in.web;

import dev.arol.petclinic.application.port.in.CreateAppointmentUseCase;
import dev.arol.petclinic.application.port.in.GetAppointmentsUseCase;
import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final GetAppointmentsUseCase getAppointmentsUseCase;

    public AppointmentController(CreateAppointmentUseCase createAppointmentUseCase,
                                 GetAppointmentsUseCase getAppointmentsUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.getAppointmentsUseCase = getAppointmentsUseCase;
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
        Appointment createdAppointment = createAppointmentUseCase.createAppointment(appointment);
        System.out.println("🚀 ID devuelto: " + createdAppointment.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return getAppointmentsUseCase.getAllAppointments();
    }
}