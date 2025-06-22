package om.healthmate.javaproject.repository;

import om.healthmate.javaproject.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
} 