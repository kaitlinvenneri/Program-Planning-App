package programplanningapp;

import java.util.ArrayList;

public class UploadCoursesMenuOption implements MenuOption {
    private int value;
    private String description;
    private Menu parentMenu;

    /**
     * Create the UploadCoursesMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public UploadCoursesMenuOption(String desc, Menu menu) {
        description = desc;
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
     * Handle the admin selecting to upload a file containing courses.
     */
    @Override
    public void handleMenuOption() {
        InputHandler inputHandler = new InputHandler();
        CourseFileParser courseFileParser = new CourseFileParser();
        String filename;
        ArrayList<AdminCourse> coursesToAdd;
        ArrayList<AdminCourse> overwrittenCourses;

        System.out.println("Please enter the name of the file containing the courses to be added");
        System.out.println("The file is assumed to be in the resources directory.");
        System.out.println("For instance for courselist.csv, only enter \"courselist.csv\":");
        System.out.println("Note that if any courses to be added already exist in the system, "
                + "they will be overwritten");
        filename = inputHandler.getFilename();
        try {
            coursesToAdd = courseFileParser.parseFile(filename);

            //update stored data regarding courses and get overwritten courses
            overwrittenCourses = DataUtility.updateStoredAdminCourses(coursesToAdd);

            if (overwrittenCourses.size() == coursesToAdd.size()) {
                System.out.println("\nNo new courses were added.");
            } else {
                System.out.println("You have input the following courses: ");
                for (Course course : coursesToAdd) {
                    System.out.println(course.toString());
                }
            }

            if (overwrittenCourses.size() > 0) {
                System.out.println("\nThe following courses have been overwritten with the following data: ");
                for (Course course : overwrittenCourses) {
                    System.out.println(course.toString());
                }
            } else {
                System.out.println("\nNo courses were overwritten.");
            }

            parentMenu.handleMenu();
        } catch (Exception e) {
            System.out.println("The filename you provided either does not exist, "
                    + "or contains an invalid file of courses.");
            handleMenuOption();
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
