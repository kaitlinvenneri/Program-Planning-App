package programplanningapp;

public class AdminMenuOption implements MenuOption {
    private int value;
    private String description;
    private Menu adminMenu;

    /**
     * Create the AdminMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public AdminMenuOption(String desc) {
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
    @Override
    public void setMenuOptionValue(int val) {
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
     * Handle the user selecting to act as an administrator.
     */
    @Override
    public void handleMenuOption() {
        createAdminMenu();
        adminMenu.handleMenu();
    }

    /**
     * Create the menu of options the administrator can choose from.
     */
    private void createAdminMenu() {
        adminMenu = new Menu("You are within the administrator menu.");
        MenuOption uploadCourses = new UploadCoursesMenuOption("Upload File Containing Courses", adminMenu);
        adminMenu.addOption(uploadCourses);
        MenuOption uploadProgram = new UploadProgramMenuOption("Upload File Containing Program Requirements",
                adminMenu);
        adminMenu.addOption(uploadProgram);
        MenuOption quitOption = new QuitMenuOption("Quit");
        adminMenu.addOption(quitOption);
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
