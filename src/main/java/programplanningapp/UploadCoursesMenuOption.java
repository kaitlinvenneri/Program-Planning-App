package programplanningapp;

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
        System.out.println("Handling of Upload Courses");
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
