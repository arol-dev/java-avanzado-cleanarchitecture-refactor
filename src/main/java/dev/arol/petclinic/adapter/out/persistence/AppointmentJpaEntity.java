package dev.arol.petclinic.adapter.out.persistence;

import dev.arol.petclinic.domain.model.Appointment;
import dev.arol.petclinic.domain.model.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pet_id", nullable = false)
    @NotNull(message = "Pet ID is required")
    private Long petId;

    @Column(nullable = false)
    @NotNull(message = "Appointment date is required")
    private LocalDateTime date;

    @Column(nullable = false)
    private String reason;

    public AppointmentJpaEntity() {}

    public AppointmentJpaEntity(Long id, Long petId, LocalDateTime date, String reason) {
        this.id = id;
        this.petId = petId;
        this.date = date;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
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
