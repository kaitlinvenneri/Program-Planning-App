package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseAttemptTest {
    private CourseAttempt courseAttemptOne;
    private String courseAttemptOneCode;
    private Status courseAttemptOneStatus;
    private int courseAttemptOneGrade;
    private String courseAttemptOneSemester;

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        courseAttemptOneCode = "CIS*4450";
        courseAttemptOneStatus = Status.COMPLETE;
        courseAttemptOneGrade = 80;
        courseAttemptOneSemester = "W20";
        courseAttemptOne = new CourseAttempt(courseAttemptOneCode, courseAttemptOneStatus, courseAttemptOneSemester);
    }

    /**
     * Test setGrade().
     */
    @Test
    public void testSetGrade() {
        courseAttemptOne.setGrade(courseAttemptOneGrade);
        assertEquals(courseAttemptOne.getGrade(), courseAttemptOneGrade);
    }

    /**
     * Test getStatus().
     */
    @Test
    public void testGetStatus() {
        assertEquals(courseAttemptOne.getStatus(), courseAttemptOneStatus);
    }

    /**
     * Test getGrade().
     */
    @Test
    public void testGetGrade() {
        courseAttemptOne.setGrade(courseAttemptOneGrade);
        assertEquals(courseAttemptOne.getGrade(), courseAttemptOneGrade);
    }

    /**
     * Test getSemester().
     */
    @Test
    public void testGetSemester() {
        assertEquals(courseAttemptOne.getSemester(), courseAttemptOneSemester);
    }
}
