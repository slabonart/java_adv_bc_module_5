package pl.slabonart.task_1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.slabonart.task_1.exception.BookLoanedException;
import pl.slabonart.task_1.exception.BookNotFoundException;
import pl.slabonart.task_1.exception.LibraryException;
import pl.slabonart.task_1.model.CheckOut;
import pl.slabonart.task_1.repository.BookRepository;
import pl.slabonart.task_1.repository.CheckOutRepository;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookCheckOutService implements CheckOutService {

    private final BookRepository bookRepository;

    private final CheckOutRepository checkOutRepository;

    private static final String CHECK_OUT_LOG_MESSAGE = "Book with id: {} loaned to user with id: {}. Return date: {}";

    @Override
    public void checkOut(Long bookId, Long userId) throws LibraryException {
        validateBook(bookId);
        validateCheckOut(bookId);

        LocalDate today = LocalDate.now();
        CheckOut checkOut = checkOutRepository.save(CheckOut.builder()
                .bookId(bookId)
                .userId(userId)
                .loanDate(today)
                .returnDate(today.plusMonths(1L))
                .build());
        log.info(CHECK_OUT_LOG_MESSAGE, checkOut.getBookId(), checkOut.getUserId(), checkOut.getReturnDate());
    }

    private void validateCheckOut(Long bookId) throws LibraryException {
        if (checkOutRepository.existsByBookId(bookId)) {
            throw new BookLoanedException("Book with id: " + bookId + " is loaned out");
        }
    }

    private void validateBook(Long bookId) throws LibraryException {
        if (!bookRepository.existsByBookId(bookId)) {
            throw new BookNotFoundException(bookId.toString());
        }
    }
}
