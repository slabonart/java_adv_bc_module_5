package pl.slabonart.task_1.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryNotificationService implements NotificationService {

    @Override
    public void notifyUser(Long userId, String message) {
        System.out.println("Sending message: \"" + message + "\" to user with id: " + userId);
    }
}
