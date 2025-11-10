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

    public boolean canPlanAppointment(){
        return petId != null && date != null;
    }
    public void validateAppointment(){
        if (petId == null){
            throw new IllegalArgumentException("Se debe especificar una mascota para poder pedir una cita");
        }
        if (date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("La hora de la cita debe ser posterior a la hora actual");
        }
    }
}