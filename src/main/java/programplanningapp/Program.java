package programplanningapp;

import java.util.ArrayList;

public class Program {
    private String name;
    private ArrayList<String> requiredCoursesByName;

    /**
     * Create the Program and initialize name and required courses.
     *
     * @param programName the name of the program
     * @param requiredCourses the required courses for the program
     */
    public Program(String programName, ArrayList<String> requiredCourses) {
        name = programName;
        requiredCoursesByName = requiredCourses;
    }
}
