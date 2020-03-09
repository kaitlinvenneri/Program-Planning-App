package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {
    private Course courseOne;
    private String courseOneCourseCode;

    /**
     *
     */
    @Before
    public void setUp() {
        courseOneCourseCode = "CIS*4450";
        courseOne = new Course(courseOneCourseCode);
    }

    /**
     *
     */
    @Test
    public void testGetCode() {
        assertEquals(courseOne.getCode(), courseOneCourseCode);
    }
}
