package pl.slabonart.task_1.service;

import pl.slabonart.task_1.exception.LibraryException;

public interface ReturnService {

    void returnBook(Long bookId) throws LibraryException;

}
