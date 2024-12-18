package pl.slabonart.task_1.service;

import pl.slabonart.task_1.exception.LibraryException;

public interface CheckOutService {

    void checkOut(Long bookId, Long userId) throws LibraryException;

}
