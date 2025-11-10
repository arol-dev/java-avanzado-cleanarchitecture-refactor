package dev.arol.petclinic.adapter.out.persistence.appointment;

import dev.arol.petclinic.adapter.out.persistence.AppointmentRepositoryJpa;
import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile({"h2", "postgres"})
public class AppointmentRepositoryAdapter implements AppointmentRepository {

    private static final Logger log = LoggerFactory.getLogger(AppointmentRepositoryAdapter.class);
    private final AppointmentRepositoryJpa appointmentRepositoryJpa;

    public AppointmentRepositoryAdapter(AppointmentRepositoryJpa appointmentRepositoryJpa) {
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

}
