package pl.slabonart.task_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import pl.slabonart.task_2.model.Employee;

import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class EmployeeFactory {

    private final Map<String, String> registry;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public EmployeeFactory() {
        this.registry = loadEmployeeConfiguration();
    }

    public Employee createEmployee(String employeeType, String name) throws EmployeeCreationException {

        try {
            Class<?> employeeClass = Class.forName(getEmployeeClassName(employeeType));
            return (Employee) employeeClass.getDeclaredConstructor(String.class).newInstance(name);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException | ClassNotFoundException e) {
            throw new EmployeeCreationException(e.getMessage());
        }
    }

    private String getEmployeeClassName(String employeeType) throws EmployeeCreationException {
        String employeeClassName = registry.get(employeeType);
        if (employeeClassName == null) {
            throw new EmployeeCreationException("Not found employee class for type: '" + employeeType + "'");
        }
        return employeeClassName;
    }

    private Map<String, String> loadEmployeeConfiguration() {
        try {
            InputStream inputStream = new ClassPathResource("/employee-config.json").getInputStream();
            return MAPPER.readValue(inputStream, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
