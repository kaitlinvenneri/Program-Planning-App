package programplanningapp;

import java.util.ArrayList;

public class AdminCourse extends Course {
    private double credits;
    private String name;
    private ArrayList<String> prerequisiteCodes;

    /**
     * Create the admin course and initialize.
     *
     * @param courseCode the course code corresponding to the course
     * @param courseCredits the number of credits associated with the course
     * @param courseName the name of the course
     * @param coursePrereqs the course codes for prerequisites of the course
     */
    public AdminCourse(String courseCode, double courseCredits, String courseName, ArrayList<String> coursePrereqs) {
        super(courseCode);
        credits = courseCredits;
        name = courseName;
        prerequisiteCodes = coursePrereqs;
    }

    /**
     * Making a human readable toString() for the admin course.
     */
    @Override
    public String toString() {
        String adminCourseString = "";
        adminCourseString = adminCourseString + "Course Code: " + super.getCode()
                + ", Course name: " + name + ", Credits: " + credits + ", Prerequisites: ";

        if (prerequisiteCodes.size() > 0) {
            adminCourseString = adminCourseString + prerequisiteCodes.get(0);

            for (int i = 1; i < prerequisiteCodes.size(); i++) {
                adminCourseString = adminCourseString + ", " + prerequisiteCodes.get(i);
            }
        } else {
            adminCourseString = adminCourseString + "N/A";
        }
        return adminCourseString;
    }
}
