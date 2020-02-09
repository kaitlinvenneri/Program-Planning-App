package programplanningapp;

public class UserMenuOption implements MenuOption {
    private int value;
    private String description;
    private Menu userMenu;

    /**
     * Create the UserMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public UserMenuOption(String desc) {
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
     * Handle the user selecting to act as a user.
     */
    @Override
    public void handleMenuOption() {
        InputHandler inputHandler = new InputHandler();
        createUserMenu();
        System.out.print(userMenu.toString());

        int command = inputHandler.getCommand();
        inputHandler.processCommand(userMenu, command);
    }

    /**
     * Create the menu of options the administrator can choose from.
     */
    private void createUserMenu() {
        userMenu = new Menu();
        MenuOption uploadTranscript = new UploadTranscriptMenuOption("Upload Transcript");
        userMenu.addOption(uploadTranscript);
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
