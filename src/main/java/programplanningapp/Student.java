package programplanningapp;

import java.util.ArrayList;

public class Student {
    private Program program;
    private ArrayList<CourseAttempt> coursesOnTranscript;

    /**
     * Create the Student.
     */
    public Student() {
    }

    /**
     * Set the courses the student has on their transcript.
     *
     * @param courses courses from transcript.
     */
    public void setCoursesOnTranscript(ArrayList<CourseAttempt> courses) {
        coursesOnTranscript = courses;
    }

    /**
     * Get the courses the student has on their transcript.
     *
     * @return The courses from transcript.
     */
    public ArrayList<CourseAttempt> getCoursesOnTranscript() {
        return coursesOnTranscript;
    }

    /**
     * Set the program the student is enrolled in.
     *
     * @param prog the student's program.
     */
    public void setProgram(Program prog) {
        program = prog;
    }

    /**
     * Get the program the student is enrolled in.
     *
     * @return the student's program.
     */
    public Program getProgram() {
        return program;
    }

}
