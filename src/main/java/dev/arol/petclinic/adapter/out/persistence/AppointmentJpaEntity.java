package dev.arol.petclinic.adapter.out.persistence;

import java.time.LocalDateTime;

import dev.arol.petclinic.domain.model.Appointment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * (Entidad JPA)
 */
@Entity
@Table(name = "appointments")
public class AppointmentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "pet_id", nullable = false)
    private Long petId;
    
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false)
    private String reason;
    
    // Constructores, getters, setters
    
    public AppointmentJpaEntity() {}
    
    public AppointmentJpaEntity(Long id, Long petId, LocalDateTime date, String reason) {
    	super();
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