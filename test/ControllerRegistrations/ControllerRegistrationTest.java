package ControllerRegistrations;

import Exceptions.IdStatus;
import controllers.ControllerJobs;
import controllers.ControllerRegistration;
import model.Job;
import model.Registration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerRegistrationTest {

    @Test
    public void afisareTest(){
        ControllerRegistration controllerRegistration=new ControllerRegistration();
        controllerRegistration.afisare();
    }
    @Test
    public void findByIdTest() throws IdStatus {
        ControllerRegistration controllerRegistration = new ControllerRegistration();
       Registration x = controllerRegistration.findById(1);
        assertEquals("7445", x.getRegistration_number());
    }

    @Test
    public void findByIdTest2() throws IdStatus {
        ControllerRegistration controllerRegistration = new ControllerRegistration();
        assertEquals(null,controllerRegistration.findById(6));
    }

    @Test
    public void adaugareTest() throws IdStatus {
        ControllerRegistration controllerRegistration = new ControllerRegistration();
         Registration x=new Registration.Builder().withRegistrationId(10).withRegistrationUserId(1).withRegistrationNumber("8859").withRegistrationDate("12/14/2005").build();
         controllerRegistration.adaugareRegistration(x);
         assertEquals(1, controllerRegistration.findById(10).getRegistration_user_id());
    }

    @Test
    public void adaugareTest2() throws IdStatus{
        ControllerRegistration controllerRegistration=new ControllerRegistration();
        Registration t =new Registration.Builder().withRegistrationId(1).withRegistrationUserId(1).withRegistrationNumber("8859").withRegistrationDate("12/14/2005").build();
        assertThrows(IdStatus.class,() -> controllerRegistration.adaugareRegistration(t));
    }

    @Test
    public void stergereTest() throws  IdStatus{
        ControllerRegistration controllerRegistration=new ControllerRegistration();
       Registration c=controllerRegistration.findById(2);
        controllerRegistration.stergereRegistration(c.getRegistration_id());
        assertEquals(null,controllerRegistration.findById(2));
    }

    @Test
    public void stergereTest2() throws IdStatus{
        ControllerRegistration controllerRegistration=new ControllerRegistration();
        assertThrows(IdStatus.class,() -> controllerRegistration.stergereRegistration(15));
    }

    @Test
    public void updateNumberTest() throws IdStatus{
        ControllerRegistration controllerRegistration=new ControllerRegistration();
        controllerRegistration.updateNumber(1,"8898");
        assertEquals("8898",controllerRegistration.findById(1).getRegistration_number());
    }

    @Test
    public void updateNumberTest2() throws IdStatus{
        ControllerRegistration controllerRegistration=new ControllerRegistration();
        assertThrows(IdStatus.class,() ->controllerRegistration.updateNumber(51,"9981"));
    }
}