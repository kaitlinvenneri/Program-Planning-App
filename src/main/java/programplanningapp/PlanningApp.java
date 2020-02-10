package programplanningapp;

public class PlanningApp {
    private Menu mainMenu;

    /**
     * Create the main menu for the app.
     *
     *  @return main menu
     */
    public Menu createMainMenu() {
        mainMenu = new Menu("This is the main menu");
        MenuOption userOption = new UserMenuOption("Act as user");
        mainMenu.addOption(userOption);
        MenuOption adminOption = new AdminMenuOption("Act as administrator");
        mainMenu.addOption(adminOption);
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
        InputHandler inputHandler = new InputHandler();
        mainMenu = createMainMenu();
        System.out.println(getWelcomeMessage());
        System.out.print(mainMenu.toString());

        int command = inputHandler.getCommand();
        inputHandler.processCommand(mainMenu, command);
    }

    private String getWelcomeMessage() {
        return "Welcome to the program planning app!\n"
                + "This application will allow you to plan your academic program.\n";
    }
}
