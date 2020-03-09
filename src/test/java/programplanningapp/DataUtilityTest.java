package programplanningapp;

//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataUtilityTest {

//    /** @noinspection checkstyle:MissingJavadocMethod*/
//    @Before
//    public void setUp() throws Exception {
//    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void testGetSavedCoursesFilename() {
        String separator = System.getProperty("file.separator");

        String filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "savedAdminCourses.csv";

        assertEquals(DataUtility.getSavedCoursesFilename(), filename);
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void getStoredAdminCourses() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void updateStoredAdminCourses() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void writeCoursesToFile() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void getSavedProgramsDirectory() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void getStoredPrograms() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void updateStoredPrograms() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void writeProgramsToFile() {
    }

    /** @noinspection checkstyle:MissingJavadocMethod*/
    @Test
    public void getProgramFilename() {
    }
}
