package dev.arol.petclinic.adapter.out.persistence.appointment;

import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile({"h2", "postgres"})
public class AppointmentRepositoryAdapter implements AppointmentRepository {
    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    public AppointmentRepositoryAdapter(AppointmentRepositoryJpa appointmentRepositoryJpa){
        this.appointmentRepositoryJpa = appointmentRepositoryJpa;
    }
    @Override
    public Appointment save(Appointment appointment) {
        AppointmentJpaEntity entity = AppointmentJpaEntity.fromDomain(appointment);
        AppointmentJpaEntity saved = appointmentRepositoryJpa.save(entity);
        return saved.toDomain();
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepositoryJpa.findAll()
                .stream()
                .map(AppointmentJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepositoryJpa.findById(id)
                .map(AppointmentJpaEntity::toDomain);
    }

    @Override
    public boolean existsById(Long id) {
        return appointmentRepositoryJpa.existsById(id);
    }
}
