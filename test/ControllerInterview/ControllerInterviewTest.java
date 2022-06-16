package ControllerInterview;

import Exceptions.IdStatus;
import controllers.ControllerInterview;
import controllers.ControllerJobs;
import model.Interview;
import model.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerInterviewTest {

    @Test
    public void afisare() {
        ControllerInterview controllerInterview = new ControllerInterview();
        controllerInterview.afisare();
    }

    @Test
    public void findByIdTest() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        Interview x = controllerInterview.findById(1);
        assertEquals("Java Developer", x.getInterview_title());
    }

    @Test
    public void findByIdTest2() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        assertEquals(null, controllerInterview.findById(60));
    }

    @Test
    public void adaugareTest() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        Interview t = new Interview.Builder().withId(10).withJobId(2).withTitle("C Developer").withDescription("descriere10").withDate("20/06/2022").build();
        controllerInterview.adaugareInterview(t);
        assertEquals(2, controllerInterview.findById(10).getInterview_job_id());
    }

    @Test
    public void adaugareTest2() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        Interview t = new Interview.Builder().withId(1).withJobId(2).withTitle("C Developer").withDescription("descriere10").withDate("20/06/2022").build();
        assertThrows(IdStatus.class, () -> controllerInterview.adaugareInterview(t));
    }

    @Test
    public void stergereTest() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        Interview c = controllerInterview.findById(2);
        controllerInterview.stergereInterview(c.getInterview_id());
        assertEquals(null, controllerInterview.findById(2));
    }

    @Test
    public void stergereTest2() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        assertThrows(IdStatus.class, () -> controllerInterview.stergereInterview(15));
    }

    @Test
    public void updateTitleTest() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        controllerInterview.updateTitle(1, "noultitlu");
        assertEquals("noultitlu", controllerInterview.findById(1).getInterview_title());
    }

    @Test
    public void updateTitleTest2() throws IdStatus {
        ControllerInterview controllerInterview = new ControllerInterview();
        assertThrows(IdStatus.class, () -> controllerInterview.updateTitle(15, "titlunou"));
    }
}