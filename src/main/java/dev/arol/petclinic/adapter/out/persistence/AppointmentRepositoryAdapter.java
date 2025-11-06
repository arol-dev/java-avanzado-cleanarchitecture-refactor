package dev.arol.petclinic.adapter.out.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;

@Repository
@Profile({"h2", "postgres"})
public class AppointmentRepositoryAdapter implements AppointmentRepository{

    @Autowired
    private AppointmentRepositoryJpa appointmentRepositoryJpa;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepositoryJpa.findAll().stream().map(AppointmentJpaEntity::toDomain).toList();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepositoryJpa.save(AppointmentJpaEntity.fromDomain(appointment)).toDomain();

    }
    
}
