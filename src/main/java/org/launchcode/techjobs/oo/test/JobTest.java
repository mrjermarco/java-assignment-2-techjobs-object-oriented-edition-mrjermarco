package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;




/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job aJob = new Job();
        Job anotherJob = new Job();
        assertNotEquals(aJob.getId(), anotherJob.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

            assertTrue(job.getName() instanceof String);
            assertEquals("Product tester", job.getName());

            assertTrue(job.getEmployer() instanceof Employer);
            assertEquals("ACME", job.getEmployer().getValue());

            assertTrue(job.getLocation() instanceof Location);
            assertEquals("Desert", job.getLocation().getValue());

            assertTrue(job.getPositionType() instanceof PositionType);
            assertEquals("Quality control", job.getPositionType().getValue());

            assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
            assertEquals("Persistence", job.getCoreCompetency().getValue());

        };


    @Test

    public void testJobsForEquality() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

     assertFalse(job.equals(anotherJob));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

             char firstChar =  job.toString().charAt(0);
             char lastChar = job.toString().charAt(job.toString().length()-1);

             assertEquals('\n', firstChar);
             assertEquals('\n', lastChar);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expected = "\nID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(expected, job.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job("Product tester", null,
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        String expected = "\nID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(expected, job.toString());

        Job nullJobName = new Job(null, new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String nameExpected = "\nID: " + nullJobName.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(nameExpected, nullJobName.toString());

        Job nullLocationName = new Job("Product tester", new Employer("ACME"),
               null, new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String locationExpected = "\nID: " + nullLocationName.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(locationExpected, nullLocationName.toString());

        Job nullPositionType = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), null,
                new CoreCompetency("Persistence"));

        String positionExpected = "\nID: " + nullPositionType.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence\n";

        assertEquals(positionExpected, nullPositionType.toString());

        Job coreCompetencyName = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                null);


        String coreCompetencyExpected = "\nID: " + coreCompetencyName.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";

        assertEquals(coreCompetencyExpected, coreCompetencyName.toString());

    }

}

