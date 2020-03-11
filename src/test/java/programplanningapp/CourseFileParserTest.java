package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseFileParserTest {
    private String filename;
    private ArrayList<AdminCourse> coursesToWrite;

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        coursesToWrite = generateAdminCourses();
        filename = generateCourseFile();
    }

    /**
     * Helper function for generating admin courses.
     *
     * @return admin courses generated
     */
    private ArrayList<AdminCourse> generateAdminCourses() {
        String courseCode = "CIS*4450";
        double courseCredits = 0.5;
        String courseName = "Advanced OOP";
        ArrayList<String> coursePrereqs = new ArrayList<>();
        coursePrereqs.add("CIS*1300");
        AdminCourse adminCourseWithNoPrereqs = new AdminCourse(courseCode, courseCredits,
                courseName, coursePrereqs);

        coursesToWrite = new ArrayList<>();
        coursesToWrite.add(adminCourseWithNoPrereqs);

        return  coursesToWrite;
    }

    /**
     * Helper function to generate a course file to test with.
     *
     * @return name of file containing admin courses
     */
    private String generateCourseFile() {
        String courseLine;
        PrintWriter myWriter = null;
        String separator = System.getProperty("file.separator");

        filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "testFileWithCourses.csv";

        try {
            myWriter = new PrintWriter(new FileWriter(new File(filename)));

            for (AdminCourse course : coursesToWrite) {
                courseLine = "";
                courseLine = courseLine + course.getCode() + ",";
                courseLine = courseLine + course.getCredits() + ",";
                courseLine = courseLine + course.getName() + ",";

                for (int i = 0; i < course.getPrerequisiteCodes().size(); i++) {
                    courseLine = courseLine + course.getPrerequisiteCodes().get(i);

                    if (i + 1 < course.getPrerequisiteCodes().size()) {
                        courseLine = courseLine + ":";
                    }
                }
                myWriter.println(courseLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            myWriter.close();
        }

        return filename;
    }

    /**
     * Helper function to check if two courses are equal.
     *
     * @param course1 first course to compare
     * @param course2 second course to compare
     * @return Boolean with result
     */
    private Boolean coursesAreEqual(AdminCourse course1, AdminCourse course2) {
        Boolean equal = true;

        if (!course1.getCode().equals(course2.getCode())) {
            equal = false;
        }

        if (!course1.getName().equals(course2.getName())) {
            equal = false;
        }

        if (course1.getCredits() != course2.getCredits()) {
            equal = false;
        }

        for (int i = 0; i < course1.getPrerequisiteCodes().size(); i++) {
            if (!course1.getPrerequisiteCodes().get(i).equals(course2.getPrerequisiteCodes().get(i))) {
                equal = false;
            }
        }

        return equal;
    }

    /**
     * Test parsing a course file.
     *
     * @throws Exception Either file IO exception, or invalid file type exception
     */
    @Test
    public void testParseFile() throws  Exception {
        ArrayList<AdminCourse> coursesFromParsed;

        try {
            coursesFromParsed = CourseFileParser.parseFile(filename);

            for (int i = 0; i < coursesToWrite.size(); i++) {
                assertTrue(coursesAreEqual(coursesFromParsed.get(i), coursesToWrite.get(i)));
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
