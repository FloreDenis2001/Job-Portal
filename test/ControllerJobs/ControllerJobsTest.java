package ControllerJobs;

import Exceptions.IdStatus;
import controllers.ControllerJobs;
import model.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerJobsTest {
    @Test
    public void JobTestAfisare() {
        ControllerJobs controllerJobs = new ControllerJobs();
        controllerJobs.afisare();
    }

    @Test
    public void findByIdTest() throws IdStatus {
        ControllerJobs controllerJobs = new ControllerJobs();
        Job x = controllerJobs.findById(1);
        assertEquals("Java", x.getJob_name());
    }

    @Test
    public void findByIdTest2() throws IdStatus {
        ControllerJobs controllerJobs = new ControllerJobs();
       assertEquals(null,controllerJobs.findById(6));
    }

    @Test
    public void adaugareTest() throws IdStatus {
        ControllerJobs controllerJobs = new ControllerJobs();
        Job t = new Job.Builder().withId(10).withName("C").withEmployeeId(2).withDescription("descriere").withType("part-time").build();
        controllerJobs.adaugareJob(t);
        assertEquals(2, controllerJobs.findById(10).getJob_employee_id());
    }

    @Test
    public void adaugareTest2() throws IdStatus{
        ControllerJobs controllerJobs=new ControllerJobs();
        Job t = new Job.Builder().withId(1).withName("C").withEmployeeId(2).withDescription("descriere").withType("part-time").build();
        assertThrows(IdStatus.class,() -> controllerJobs.adaugareJob(t));
    }

    @Test
    public void stergereTest() throws  IdStatus{
        ControllerJobs controllerJobs=new ControllerJobs();
        Job c=controllerJobs.findById(2);
        controllerJobs.stergereJob(c.getJob_id());
        assertEquals(null,controllerJobs.findById(2));
    }

    @Test
    public void stergereTest2() throws IdStatus{
        ControllerJobs controllerJobs=new ControllerJobs();
        assertThrows(IdStatus.class,() -> controllerJobs.stergereJob(15));
    }

    @Test
    public void updateDescriereTest() throws IdStatus{
        ControllerJobs controllerJobs=new ControllerJobs();
        controllerJobs.updateDescriere(1,"nouadescriere");
        assertEquals("nouadescriere",controllerJobs.findById(1).getJob_description());
    }

    @Test
    public void updateDescriereTest2() throws IdStatus{
        ControllerJobs controllerJobs=new ControllerJobs();
        assertThrows(IdStatus.class,() ->controllerJobs.updateDescriere(4,"descrierenoua"));
    }

}