package programplanningapp;

import java.util.ArrayList;

public class UploadCoursesMenuOption implements MenuOption {
    private int value;
    private String description;

    /**
     * Create the UploadCoursesMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public UploadCoursesMenuOption(String desc) {
        description = desc;
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
        ArrayList<Course> courses;

        System.out.println("Please enter the name of the file containing the courses to be added");
        System.out.println("The file is assumed to be in the resources directory.");
        System.out.println("For instance for courselist.csv, only enter \"courselist.csv\":");
        filename = inputHandler.getFilename();
        try {
            courses = courseFileParser.parseFile(filename);

            System.out.println("You have input the following courses: ");
            for (Course course : courses) {
                System.out.println(course.toString());
            }
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
