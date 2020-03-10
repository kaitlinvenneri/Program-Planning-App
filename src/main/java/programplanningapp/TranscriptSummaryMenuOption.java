package programplanningapp;

import java.util.ArrayList;

public class TranscriptSummaryMenuOption implements MenuOption {
    private int value;
    private String description;
    private Student student;
    private Menu parentMenu;

    /**
     * Create the UploadTranscriptMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     * @param aStudent student to provide summary for
     */
    public TranscriptSummaryMenuOption(String desc, Student aStudent, Menu menu) {
        description = desc;
        student = aStudent;
        parentMenu = menu;
    }

    /**
     * Get the description of the menu option.
     *
     * @return The description of the menu option.
     */
    @Override
    public String getMenuOptionDescription() {
        return description;
    }

    /**
     * Set the value of the menu option.
     *
     * @param val The value of the menu option.
     */
    @Override public void setMenuOptionValue(int val) {
        value = val;
    }

    /**
     * Get the value of the menu option.
     *
     * @return The value of the menu option.
     */
    @Override public int getMenuOptionValue() {
        return value;
    }

    /**
     * Handle the user selecting to upload a transcript.
     */
    @Override
    public void handleMenuOption() {
        ArrayList<CourseAttempt> courses = student.getCoursesOnTranscript();
        ArrayList<CourseAttempt> completedCourses = new ArrayList<>();
        ArrayList<CourseAttempt> inProgressCourses = new ArrayList<>();
        ArrayList<CourseAttempt> plannedCourses = new ArrayList<>();

        for (CourseAttempt course : courses) {
            if (course.getStatus() == Status.COMPLETE) {
                completedCourses.add(course);
            } else if (course.getStatus() == Status.IN_PROGRESS) {
                inProgressCourses.add(course);
            } else {
                plannedCourses.add(course);
            }
        }

        System.out.println("Transcript Summary");
        if (completedCourses.size() == 0) {
            System.out.println("You have not completed any courses");
        } else {
            System.out.println("Courses Completed:");
            for (CourseAttempt courseAttempt : completedCourses) {
                System.out.println(courseAttempt.toString());
            }
        }

        if (inProgressCourses.size() == 0) {
            System.out.println("\nYou have no courses in progress");
        } else {
            System.out.println("\nCourses In Progress:");
            for (CourseAttempt courseAttempt : inProgressCourses) {
                System.out.println(courseAttempt.toString());
            }
        }

        if (plannedCourses.size() == 0) {
            System.out.println("\nYou have no courses planned");
        } else {
            System.out.println("\nCourses Planned:");
            for (CourseAttempt courseAttempt : plannedCourses) {
                System.out.println(courseAttempt.toString());
            }
        }
        parentMenu.handleMenu();
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
