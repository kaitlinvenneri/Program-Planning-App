package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramTest {
    private Program program;
    private String name;
    private ArrayList<String> requiredCoursesByCode;

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        name = "Comp Sci";
        requiredCoursesByCode = new ArrayList<>();
        program = new Program(name, requiredCoursesByCode);
    }

    /**
     * Test getName().
     */
    @Test
    public void testGetName() {
        assertEquals(program.getName(), name);
    }

    /**
     * Test getRequiredCoursesByCode().
     */
    @Test
    public void testGetRequiredCoursesByCode() {
        assertEquals(program.getRequiredCoursesByCode(), requiredCoursesByCode);
    }

    /**
     * Test setRequiredCoursesByCode().
     */
    @Test
    public void testSetRequiredCoursesByCode() {
        ArrayList<String> newRequiredCoursesByCode = new ArrayList<>();
        newRequiredCoursesByCode.add("CIS*1300");

        program.setRequiredCoursesByCode(newRequiredCoursesByCode);
        assertEquals(program.getRequiredCoursesByCode(), newRequiredCoursesByCode);
    }
}
