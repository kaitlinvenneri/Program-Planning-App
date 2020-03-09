package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminCourseTest {
    private AdminCourse adminCourseWithNoPrereqs;
    private AdminCourse adminCourseWithPrereqs;
    private String courseCode;
    private double courseCredits;
    private String courseName;
    private ArrayList<String> emptyCoursePrereqs;
    private ArrayList<String> coursePrereqs;
    private static final double DELTA = 1e-15;


    /**
     *
     */
    @Before
    public void setUp() {
        courseCode = "CIS*4450";
        courseCredits = 0.5;
        courseName = "Advanced OOP";
        emptyCoursePrereqs = new ArrayList<>();
        coursePrereqs = new ArrayList<>();
        coursePrereqs.add("CIS*1300");
        adminCourseWithNoPrereqs = new AdminCourse(courseCode, courseCredits, courseName, emptyCoursePrereqs);
        adminCourseWithPrereqs = new AdminCourse(courseCode, courseCredits, courseName, coursePrereqs);
    }

    /**
     *
     */
    @Test
    public void testGetName() {
        assertEquals(adminCourseWithPrereqs.getName(), courseName);
    }

    /**
     *
     */
    @Test
    public void testGetCredits() {
        assertEquals(adminCourseWithPrereqs.getCredits(), courseCredits, DELTA);
    }

    /**
     *
     */
    @Test
    public void testGetPrerequisiteCodes() {
        assertEquals(adminCourseWithNoPrereqs.getPrerequisiteCodes(), emptyCoursePrereqs);

        assertEquals(adminCourseWithPrereqs.getPrerequisiteCodes(), coursePrereqs);
    }

    /**
     *
     */
    @Test
    public void testSetName() {
        String newName = "Judi's Class";
        adminCourseWithPrereqs.setName(newName);
        assertEquals(adminCourseWithPrereqs.getName(), newName);
    }

    /**
     *
     */
    @Test
    public void testSetCredits() {
        double newCredits = 0.75;
        adminCourseWithPrereqs.setCredits(newCredits);
        assertEquals(adminCourseWithPrereqs.getCredits(), newCredits, DELTA);
    }

    /**
     *
     */
    @Test
    public void testSetPrerequisiteCodes() {
        adminCourseWithNoPrereqs.setPrerequisiteCodes(coursePrereqs);
        assertEquals(adminCourseWithNoPrereqs.getPrerequisiteCodes(), coursePrereqs);
    }

    /**
     *
     */
    @Test
    public void testUpdateCourseInfo() {
        double newCourseCredits = 0.5;
        String newCourseName = "Advanced OOP";
        ArrayList<String> newCoursePrereqs = new ArrayList<>();
        newCoursePrereqs = new ArrayList<>();
        newCoursePrereqs.add("CIS*2500");
        AdminCourse newAdminCourse = new AdminCourse(courseCode, newCourseCredits, newCourseName, newCoursePrereqs);

        adminCourseWithPrereqs.updateCourseInfo(newAdminCourse);

        assertEquals(adminCourseWithPrereqs.getName(), newCourseName);
        assertEquals(adminCourseWithPrereqs.getCredits(), newCourseCredits, DELTA);
        assertEquals(adminCourseWithPrereqs.getPrerequisiteCodes(), newCoursePrereqs);
    }

    /**
     *
     */
    @Test
    public void testToString() {

    }
}
