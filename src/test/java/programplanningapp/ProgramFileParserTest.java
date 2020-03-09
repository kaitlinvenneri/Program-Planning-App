package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramFileParserTest {
    private String filename;
    private Program programToWrite;

    /**
     * Setup member variables for tests.
     *
     * @throws Exception Either file IO exception, or invalid file type exception
     */
    @Before
    public void setUp() throws Exception {
        generateProgram();
        generateProgramFile();
    }

    /**
     * Helper function for generating a program.
     */
    private void generateProgram() {
        String name = "Comp Sci";
        ArrayList<String> requiredCoursesByName = new ArrayList<>();
        requiredCoursesByName.add("CIS*4450");
        programToWrite = new Program(name, requiredCoursesByName);
    }

    /**
     * Helper function to generate a program file to test with.
     */
    private void generateProgramFile() {
        String separator = System.getProperty("file.separator");

        filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "testFileWithProgram.csv";

        String programLine;
        PrintWriter myWriter = null;

        try {
            myWriter = new PrintWriter(new FileWriter(new File(filename)));

            programLine = "";
            programLine = programLine + programToWrite.getName() + ",";

            for (int i = 0; i < programToWrite.getRequiredCoursesByName().size(); i++) {
                programLine = programLine + programToWrite.getRequiredCoursesByName().get(i);

                if (i + 1 < programToWrite.getRequiredCoursesByName().size()) {
                    programLine = programLine + ",";
                }
            }
            myWriter.println(programLine);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            myWriter.close();
        }
    }

    /**
     * Helper function to check if two programs are equal.
     *
     * @param program1 first program to compare
     * @param program2 second program to compare
     * @return Boolean with result
     */
    private Boolean programsAreEqual(Program program1, Program program2) {
        Boolean equal = true;

        if (!program1.getName().equals(program2.getName())) {
            equal = false;
        }

        for (int i = 0; i < program1.getRequiredCoursesByName().size(); i++) {
            if (!program1.getRequiredCoursesByName().get(i).equals(program2.getRequiredCoursesByName().get(i))) {
                equal = false;
            }
        }

        return equal;
    }

    /**
     * Test parsing a program file.
     *
     * @throws Exception Either file IO exception, or invalid file type exception
     */
    @Test
    public void testParseFile() throws Exception {
        ProgramFileParser programFileParser = new ProgramFileParser();
        Program programFromParsed;

        try {
            programFromParsed = programFileParser.parseFile(filename);
            assertTrue(programsAreEqual(programFromParsed, programToWrite));
        } catch (Exception e) {
            throw e;
        }
    }
}
