package pl.slabonart.task_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.slabonart.task_1.exception.BookNotFoundException;
import pl.slabonart.task_1.exception.LibraryException;
import pl.slabonart.task_1.repository.BookRepository;
import pl.slabonart.task_1.repository.CheckOutRepository;

@Service
@RequiredArgsConstructor
public class BookReturnService implements ReturnService {

    private final BookRepository bookRepository;

    private final CheckOutRepository checkOutRepository;

    @Override
    public void returnBook(Long bookId) throws LibraryException {
        validateBook(bookId);
        checkOutRepository.deleteByBookId(bookId);
    }

    private void validateBook(Long bookId) throws LibraryException {
        if (!bookRepository.existsByBookId(bookId)) {
            throw new BookNotFoundException(bookId.toString());
        }
    }
}
