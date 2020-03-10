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
     * @param menu The menu that this menu option belongs to.
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

        System.out.print(getTranscriptSummary(completedCourses, inProgressCourses, plannedCourses));

        parentMenu.handleMenu();
    }

    private String getTranscriptSummary(ArrayList<CourseAttempt> completedCourses,
                                        ArrayList<CourseAttempt> inProgressCourses,
                                        ArrayList<CourseAttempt> plannedCourses) {
        String transcriptSummary = "Transcript Summary\n";

        if (completedCourses.size() == 0) {
            transcriptSummary = transcriptSummary + "You have not completed any courses\n";
        } else {
            transcriptSummary = transcriptSummary + "Courses Completed:\n";

            for (CourseAttempt courseAttempt : completedCourses) {
                transcriptSummary = transcriptSummary + courseAttempt.toString() + "\n";
            }
        }

        if (inProgressCourses.size() == 0) {
            transcriptSummary = transcriptSummary + "\nYou have no courses in progress\n";
        } else {
            transcriptSummary = transcriptSummary + "\nCourses In Progress:\n";
            for (CourseAttempt courseAttempt : inProgressCourses) {
                transcriptSummary = transcriptSummary + courseAttempt.toString() + "\n";
            }
        }

        if (plannedCourses.size() == 0) {
            transcriptSummary = transcriptSummary + "\nYou have no courses planned\n";
        } else {
            transcriptSummary = transcriptSummary + "\nCourses Planned:\n";
            for (CourseAttempt courseAttempt : plannedCourses) {
                transcriptSummary = transcriptSummary + courseAttempt.toString() + "\n";
            }
        }

        return transcriptSummary;
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
