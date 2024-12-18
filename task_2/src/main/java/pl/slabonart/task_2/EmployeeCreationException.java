package pl.slabonart.task_2;

public class EmployeeCreationException extends Exception {

    private static final String MESSAGE = "Error while creating en employee: ";

    public EmployeeCreationException(String message) {
        super(MESSAGE + message);
    }
}
