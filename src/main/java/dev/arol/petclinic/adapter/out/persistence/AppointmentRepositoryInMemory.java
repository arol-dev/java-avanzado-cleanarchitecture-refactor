package dev.arol.petclinic.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import dev.arol.petclinic.application.port.out.AppointmentRepository;
import dev.arol.petclinic.domain.model.Appointment;

@Repository
@Profile("inmemory")
public class AppointmentRepositoryInMemory implements AppointmentRepository {
    
    private final ConcurrentHashMap<Long, Appointment> appointments = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    @Override
    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment = new Appointment(idGenerator.getAndIncrement(), 
                         appointment.getPetId(), appointment.getDate(), appointment.getReason());
        }
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return Optional.ofNullable(appointments.get(id));
    }

    @Override
    public List<Appointment> findAll() {
        return appointments.values().stream().toList();
    }

    @Override
    public boolean existsById(Long id) {
        return appointments.containsKey(id);
    }

    @Override
    public void deleteById(Long id) {
        appointments.remove(id);
    }

    @Override
    public long count() {
        return appointments.size();
    }
    
}