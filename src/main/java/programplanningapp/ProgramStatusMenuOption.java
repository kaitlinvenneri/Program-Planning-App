package programplanningapp;

import java.util.ArrayList;

public class ProgramStatusMenuOption implements MenuOption {
    private int value;
    private String description;
    private Student student;

    /**
     * Create the ProgramStatusMenuOption and initialize.
     *
     * @param desc The description to be assigned.
     * @param aStudent The student to get a program status for
     */
    public ProgramStatusMenuOption(String desc, Student aStudent) {
        description = desc;
        student = aStudent;
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
     * Handle the user selecting to get a program status.
     */
    @Override
    public void handleMenuOption() {
        Program program = student.getProgram();
        ArrayList<String> passedCourseCodes = new ArrayList<>();
        ArrayList<String> courseCodesNeeded = new ArrayList<>();
        Boolean courseCompleted;

        //check which courses have been completed and passed (grade of 50 or above)
        for (String courseCode : program.getRequiredCoursesByName()) {
            courseCompleted = false;
            for (CourseAttempt courseAttempt : student.getCoursesOnTranscript()) {
                if (courseAttempt.getCode().equals(courseCode)
                        && courseAttempt.getStatus() == Status.COMPLETE
                        && courseAttempt.getGrade() > 49) {
                    courseCompleted = true;
                    passedCourseCodes.add(courseCode);
                }
            }

            if (!courseCompleted) {
                courseCodesNeeded.add(courseCode);
            }
        }

        if (passedCourseCodes.size() > 0) {
            System.out.println("Courses completed toward program: ");

            for (String code : passedCourseCodes) {
                System.out.println(code);
            }
        }

        if (passedCourseCodes.size() > 0) {
            System.out.println("\nCourses still needed for your program: ");

            for (String code : courseCodesNeeded) {
                System.out.println(code);
            }
        } else {
            System.out.println("\nYou have completed all courses for your program. Congratulations!");
        }
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
