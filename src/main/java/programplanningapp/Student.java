package programplanningapp;

import java.util.ArrayList;

public class Student {
    private ArrayList<Course> coursesOnTranscript;

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
    public void setCoursesOnTranscript(ArrayList<Course> courses) {
        coursesOnTranscript = courses;
    }

    /**
     * Get the courses the student has on their transcript.
     *
     * @return The courses from transcript.
     */
    public ArrayList<Course> getCoursesOnTranscript() {
        return coursesOnTranscript;
    }
}
