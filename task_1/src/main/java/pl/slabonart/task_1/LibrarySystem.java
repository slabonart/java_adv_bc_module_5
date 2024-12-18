package pl.slabonart.task_1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.slabonart.task_1.exception.BookLoanedException;
import pl.slabonart.task_1.exception.LibraryException;
import pl.slabonart.task_1.service.CheckOutService;
import pl.slabonart.task_1.service.ReservationService;
import pl.slabonart.task_1.service.ReturnService;

@Slf4j
@Component
@RequiredArgsConstructor
public class LibrarySystem {

    private final CheckOutService checkOutService;
    private final ReturnService returnService;
    private final ReservationService reservationService;

    public void checkOutBook(String bookId, String userId) {
        try {
            checkOutService.checkOut(Long.parseLong(bookId), Long.parseLong(userId));
        } catch (BookLoanedException e) {
            log.error(e.getMessage());
            reservationService.reserve(Long.parseLong(bookId), Long.parseLong(userId));
        } catch (LibraryException e) {
            log.error(e.getMessage());
        }
    }

    public void returnBook(String bookId){
        try {
            returnService.returnBook(Long.parseLong(bookId));
        } catch (LibraryException e) {
            log.error(e.getMessage());
        }
    }
}

