package ControllerEmployee;

import Exceptions.IdStatus;
import controllers.ControllerEmployee;
import model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerEmployeeTest {
    @Test
    public void afisareTest() {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        controllerEmployee.afisare();
    }

    @Test
    public void findById() {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        assertEquals("Martina", controllerEmployee.findById(1).getEmployee_name());
    }

    @Test
    public void findById2() {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        assertEquals(null, controllerEmployee.findById(100));
    }

    @Test
    public void adaugareTest1() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        Employee t = new Employee.Builder().withId(7).withName("Denis").withEmail("denis@yahoo.com").withAddress("44643").withMobile("0744111123").withUserName("denis112").withPassword("parola1").build();
        controllerEmployee.adaugareEmployee(t);
        assertEquals("Denis", controllerEmployee.findById(7).getEmployee_name());
    }

    @Test
    public void adaugareTest2() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        Employee t = new Employee.Builder().withId(5).withName("Denis").withEmail("denis@yahoo.com").withAddress("44643").withMobile("0744111123").withUserName("denis112").withPassword("parola1").build();
        assertThrows(IdStatus.class, () -> controllerEmployee.adaugareEmployee(t));
    }

    @Test
    public void stergereEmployeeTest1() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        controllerEmployee.stergereEmployee(1);
        assertEquals(null, controllerEmployee.findById(1));
    }

    @Test
    public void stergereEmployeeTest2() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        assertThrows(IdStatus.class, () -> controllerEmployee.stergereEmployee(7));
    }

    @Test
    public void updateEmployee1() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        controllerEmployee.updatePassword(1, "parolanoua");
        assertEquals("parolanoua", controllerEmployee.findById(1).getEmployee_password());
    }

    @Test
    public void updateEmployee2() throws IdStatus {
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        assertThrows(IdStatus.class, () -> controllerEmployee.updatePassword(16, "parola"));
    }
}