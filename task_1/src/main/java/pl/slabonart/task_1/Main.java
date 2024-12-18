package pl.slabonart.task_1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        LibrarySystem librarySystem = context.getBean(LibrarySystem.class);

        System.out.println("Welcome to LIBRARY 1.0");

        librarySystem.checkOutBook("5", "1");
        librarySystem.checkOutBook("1", "1");
        librarySystem.checkOutBook("1", "2");
        librarySystem.returnBook("1");
        librarySystem.checkOutBook("1", "2");

    }
}
