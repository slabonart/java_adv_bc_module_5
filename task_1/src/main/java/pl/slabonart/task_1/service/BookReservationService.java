package pl.slabonart.task_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.slabonart.task_1.model.Reservation;
import pl.slabonart.task_1.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class BookReservationService implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final NotificationService notificationService;

    @Override
    public void reserve(Long bookId, Long userId) {

        Reservation reservation = Reservation.builder()
                .bookId(bookId)
                .userId(userId)
                .build();

        reservationRepository.save(reservation);
        notificationService.notifyUser(userId, "Reservation for book with id: " + bookId + " was made for you");
    }
}
