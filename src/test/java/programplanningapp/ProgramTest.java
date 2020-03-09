package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramTest {
    private Program program;
    private String name;
    private ArrayList<String> requiredCoursesByName;

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        name = "Comp Sci";
        requiredCoursesByName = new ArrayList<>();
        program = new Program(name, requiredCoursesByName);
    }

    /**
     * Test getName().
     */
    @Test
    public void testGetName() {
        assertEquals(program.getName(), name);
    }

    /**
     * Test getRequiredCoursesByName().
     */
    @Test
    public void testGetRequiredCoursesByName() {
        assertEquals(program.getRequiredCoursesByName(), requiredCoursesByName);
    }

    /**
     * Test setRequiredCoursesByName().
     */
    @Test
    public void testSetRequiredCoursesByName() {
        ArrayList<String> newRequiredCoursesByName = new ArrayList<>();
        newRequiredCoursesByName.add("CIS*1300");

        program.setRequiredCoursesByName(newRequiredCoursesByName);
        assertEquals(program.getRequiredCoursesByName(), newRequiredCoursesByName);
    }
}
