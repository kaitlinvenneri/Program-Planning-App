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
        InputHandler inputHandler = new InputHandler();
        createAdminMenu();
        System.out.print(adminMenu.toString());

        int command = inputHandler.getCommand();
        inputHandler.processCommand(adminMenu, command);
    }

    /**
     * Create the menu of options the administrator can choose from.
     */
    private void createAdminMenu() {
        adminMenu = new Menu();
        MenuOption uploadCourses = new UploadCoursesMenuOption("Upload File Containing Courses");
        adminMenu.addOption(uploadCourses);
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
