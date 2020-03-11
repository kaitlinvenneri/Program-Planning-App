package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class TranscriptFileParserTest {
    private String filename;
    private ArrayList<CourseAttempt> coursesToWrite;

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        generateCourseAttempts();
        generateTranscriptFile();
    }

    /**
     * Helper function to make some random course attempts.
     *
     * @return random course attempt
     */
    private CourseAttempt createRandomCourseAttempt() {
        String courseCode = "CIS*1500";

        CourseAttempt courseAttempt;
        Random rand = new Random();
        int statusVal;
        int grade;
        Status status;
        String semesterLetter;
        int semesterRand;
        int semesterYear;
        String semesterString;

        statusVal = rand.nextInt(3);

        if (statusVal == 0) {
            status = Status.COMPLETE;
        } else if (statusVal == 1) {
            status = Status.IN_PROGRESS;
        } else {
            status = Status.PLANNED;
        }

        grade = rand.nextInt(101);

        semesterRand = rand.nextInt(3);

        if (semesterRand == 0) {
            semesterLetter = "F";
        } else if (semesterRand == 1) {
            semesterLetter = "W";
        } else {
            semesterLetter = "S";
        }

        semesterRand = rand.nextInt(7);

        semesterYear = semesterRand + 14;

        semesterString = semesterLetter + semesterYear;

        courseAttempt = new CourseAttempt(courseCode, status, semesterString);
        courseAttempt.setGrade(grade);

        return courseAttempt;
    }

    /**
     * Helper function for generating course attempts.
     */
    private void generateCourseAttempts() {
        coursesToWrite = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            coursesToWrite.add(createRandomCourseAttempt());

        }
    }

    /**
     * Helper function to generate a transcript file to test with.
     */
    private void generateTranscriptFile() {
        String courseAttemptLine;
        PrintWriter myWriter = null;
        Status status;
        String statusString;
        String separator = System.getProperty("file.separator");

        filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "testTranscript.csv";

        try {
            myWriter = new PrintWriter(new FileWriter(new File(filename)));

            for (CourseAttempt courseAttempt : coursesToWrite) {
                courseAttemptLine = "";
                courseAttemptLine = courseAttemptLine + courseAttempt.getCode() + ",";

                status = courseAttempt.getStatus();

                if (status == Status.COMPLETE) {
                    statusString = "Complete";
                } else if (status == Status.IN_PROGRESS) {
                    statusString = "InProgress";
                } else {
                    statusString = "Planned";
                }

                courseAttemptLine = courseAttemptLine + statusString + ",";

                if (status == Status.COMPLETE) {
                    courseAttemptLine = courseAttemptLine + courseAttempt.getGrade();
                }

                courseAttemptLine = courseAttemptLine + ",";

                courseAttemptLine = courseAttemptLine + courseAttempt.getSemester();

                myWriter.println(courseAttemptLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            myWriter.close();
        }
    }

    /**
     * Helper function to check if two courses are equal.
     *
     * @param course1 first course to compare
     * @param course2 second course to compare
     * @return Boolean with result
     */
    private Boolean coursesAreEqual(CourseAttempt course1, CourseAttempt course2) {
        Boolean equal = true;

        if (!course1.getCode().equals(course2.getCode())) {
            equal = false;
        }

        if (!course1.getStatus().equals(course2.getStatus())) {
            equal = false;
        }

        if (course1.getStatus() == Status.COMPLETE) {
            if (course1.getGrade() != course2.getGrade()) {
                equal = false;
            }
        }

        if (!course1.getSemester().equals(course2.getSemester())) {
            equal = false;
        }

        return equal;
    }

    /**
     * Test parsing a transcript file.
     *
     * @throws Exception Either file IO exception, or invalid file type exception
     */
    @Test
    public void testParseFile() throws Exception {
        ArrayList<CourseAttempt> coursesFromParsed;

        try {
            coursesFromParsed = TranscriptFileParser.parseFile(filename);

            for (int i = 0; i < coursesToWrite.size(); i++) {
                assertTrue(coursesAreEqual(coursesFromParsed.get(i), coursesToWrite.get(i)));
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
