package pl.slabonart.task_1.exception;

public class BookNotFoundException extends LibraryException {

    private static final String MESSAGE = "Book with id %s does not exist!!!";

    public BookNotFoundException(String message) {
        super(String.format(MESSAGE, message));
    }
}
