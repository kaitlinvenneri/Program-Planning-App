package programplanningapp;

public class PlanningApp {
    private Menu mainMenu;

    /**
     * Create the main menu for the app.
     *
     *  @return main menu
     */
    public Menu createMainMenu() {
        mainMenu = new Menu("This is the main menu. Please note that once you "
                + "select between administrator and user, "
                + "you will need to restart the application to change user type.");
        MenuOption adminOption = new AdminMenuOption("Act as administrator");
        mainMenu.addOption(adminOption);
        MenuOption userOption = new UserMenuOption("Act as user");
        mainMenu.addOption(userOption);
        MenuOption quitOption = new QuitMenuOption("Quit");
        mainMenu.addOption(quitOption);
        return mainMenu;
    }

    /**
     * Main method.
     *
     *  @param args  command line arguments are ignored for now
     */
    public static void main(String[] args) {
        PlanningApp planningApp = new PlanningApp();
        planningApp.setup();
    }

    /**
     * Method for setting up the app.
     */
    private void setup() {
        mainMenu = createMainMenu();
        mainMenu.handleMenu();
    }

    private String getWelcomeMessage() {
        return "Welcome to the program planning app!\n"
                + "This application will allow you to plan your academic program.\n";
    }
}
