package pl.slabonart.task_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.slabonart.task_2.model.Employee;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        EmployeeFactory factory = new EmployeeFactory();

        try {
            List<Employee> employees = List.of(
                    factory.createEmployee("COMMISSIONED", "John"),
                    factory.createEmployee("HOURLY", "Ann"),
                    factory.createEmployee("SALARIED", "Peter")
            );
            employees.forEach(Main::process);
        } catch (EmployeeCreationException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void process(Employee employee) {
        System.out.println("EmployeeInt type: " + employee.getType());
        System.out.println("EmployeeInt name: " + employee.getName());
        System.out.println("Pay: " + employee.calculatePay().toString());
        System.out.println("Bonus: " + employee.calculateBonus().toString() + "\n");

    }
}