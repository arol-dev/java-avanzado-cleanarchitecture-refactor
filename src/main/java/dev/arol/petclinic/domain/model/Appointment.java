package dev.arol.petclinic.domain.model;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    private Long petId;
    private LocalDateTime date;
    private String reason;

    public Appointment() {}

    public Appointment(Long id, Long petId, LocalDateTime date, String reason) {
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
    
    public void validateForCreation() {
        if (petId == null) {
            throw new IllegalArgumentException("El ID de la mascota es obligatorio");
        }
        if (date == null) {
            throw new IllegalArgumentException("La fecha de la cita es obligatoria");
        }
        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("La razón de la cita es obligatoria");
        }
    }
}