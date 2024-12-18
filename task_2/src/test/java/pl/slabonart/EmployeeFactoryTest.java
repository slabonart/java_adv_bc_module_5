package pl.slabonart;

import org.junit.jupiter.api.Test;
import pl.slabonart.task_2.EmployeeCreationException;
import pl.slabonart.task_2.EmployeeFactory;
import pl.slabonart.task_2.model.CommissionedEmployee;
import pl.slabonart.task_2.model.Employee;
import pl.slabonart.task_2.model.HourlyEmployee;
import pl.slabonart.task_2.model.SalariedEmployee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private static final String TEST_EMPLOYEE_NAME = "TestName";
    private static final String COMMISSIONED_TYPE = "COMMISSIONED";
    private static final String HOURLY_TYPE = "HOURLY";
    private static final String SALARIED_TYPE = "SALARIED";
    private static final String WRONG_TYPE = "WRONG";

    private final EmployeeFactory employeeFactory = new EmployeeFactory();

    @Test
    void whenGenerateCommissionedEmployee_thenSuccess() throws EmployeeCreationException {

        Employee employee = employeeFactory.createEmployee(COMMISSIONED_TYPE, TEST_EMPLOYEE_NAME);

        assertInstanceOf(CommissionedEmployee.class, employee);
        assertEquals(TEST_EMPLOYEE_NAME, employee.getName());
        assertEquals(COMMISSIONED_TYPE, employee.getType());
    }

    @Test
    void whenGenerateHourlyEmployee_thenSuccess() throws EmployeeCreationException {

        Employee employee = employeeFactory.createEmployee(HOURLY_TYPE, TEST_EMPLOYEE_NAME);

        assertInstanceOf(HourlyEmployee.class, employee);
        assertEquals(TEST_EMPLOYEE_NAME, employee.getName());
        assertEquals(HOURLY_TYPE, employee.getType());
    }

    @Test
    void whenGenerateSalariedEmployee_thenSuccess() throws EmployeeCreationException {

        Employee employee = employeeFactory.createEmployee(SALARIED_TYPE, TEST_EMPLOYEE_NAME);

        assertInstanceOf(SalariedEmployee.class, employee);
        assertEquals(TEST_EMPLOYEE_NAME, employee.getName());
        assertEquals(SALARIED_TYPE, employee.getType());
    }

    @Test
    void whenGenerateEmployeeForNotExistingType_thenException() {

        Exception exception = assertThrows(Exception.class, () -> employeeFactory.createEmployee(WRONG_TYPE, TEST_EMPLOYEE_NAME));

        assertInstanceOf(EmployeeCreationException.class, exception);
        assertEquals("Error while creating en employee: Not found employee class for type: 'WRONG'", exception.getMessage());
    }
}
