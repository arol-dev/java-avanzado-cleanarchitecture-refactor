package dev.arol.petclinic.adapter.out.persistence;

import java.time.LocalDateTime;

import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Pet ID is required")
    private Long petId;

    @Column(nullable = false)
    @NotNull(message = "Appointment date is required")
    private LocalDateTime date;

    @Column(name = "owner_name", nullable = false)
    private String reason;

    // Constructores, getters, setters
    public AppointmentJpaEntity() {}

    public AppointmentJpaEntity(Long id, Long petId, LocalDateTime date, String reason) {
        this.id = id;
        this.petId = petId;
        this.date = date;
        this.reason = reason;
    }

    // Método para convertir a entidad de dominio
    public Appointment toDomain() {
        return new Appointment(id, petId, date, reason);
    }

    // Método para crear desde entidad de dominio
    public static AppointmentJpaEntity fromDomain(Appointment appointment) {
        return new AppointmentJpaEntity(appointment.getId(), appointment.getPetId(),
                appointment.getDate(), appointment.getReason());
    }
}
