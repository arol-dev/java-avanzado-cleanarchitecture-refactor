package dev.arol.petclinic.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    public void validateDate() {
        if (date == null || date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la cita debe ser futura");
        }
    }

    public boolean isUrgent() {
        return reason != null && reason.toLowerCase().contains("urgente");
    }

    public boolean isWeekendAppointment() {
        if (date == null) return false;
        var day = date.getDayOfWeek();
        return day == java.time.DayOfWeek.SATURDAY || day == java.time.DayOfWeek.SUNDAY;
    }

    public boolean isSameDay(LocalDateTime otherDate) {
        return date != null && otherDate != null &&
                date.toLocalDate().equals(otherDate.toLocalDate());
    }

    public String getSummary() {
        return "Cita para mascota ID " + petId + " el " + date + ": " + reason;
    }
}