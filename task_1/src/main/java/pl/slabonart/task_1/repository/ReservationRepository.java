package pl.slabonart.task_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.slabonart.task_1.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
