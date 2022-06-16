package Employee;

import model.Employee;
import model.Job;
import org.junit.jupiter.api.Test;

class BuilderTest {

    @Test
    public void builderTest() {
        Employee employee = new Employee.Builder()
                .withId(1)
                .withName("Denis")
                .withEmail("denis@yahoo.com")
                .withMobile("112")
                .withUserName("flore2001")
                .withPassword("parola1")
                .withAddress("Intrarea Iorga")
                .build();

//        System.out.println(employee);

        Job job = new Job.Builder()
                .withId(3)
                .withEmployeeId(1)
                .withName("Java developer")
                .withType("Full Time")
                .withDescription("descriere1")
                .build();
        Job job1 = new Job.Builder()
                .withId(2)
                .withEmployeeId(1)
                .withName("Java developer")
                .withType("Full Time")
                .withDescription("descriere1")
                .build();
        //System.out.println(job.compareTo(job1));
        // System.out.println(job.equals(job1));
    }

}