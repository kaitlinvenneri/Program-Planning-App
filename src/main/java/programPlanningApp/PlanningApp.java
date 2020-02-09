package programplanningapp;

public class PlanningApp {
    private Menu mainMenu;

    /**
     * Method for setting up the app.
     */
    public void setup() {
        InputHandler inputHandler = new InputHandler();
        mainMenu = createMainMenu();
        System.out.print(mainMenu.toString());

        int command = inputHandler.getCommand();
        inputHandler.processCommand(mainMenu, command);
    }

    /**
     * Create the main menu for the app.
     *
     *  @return main menu
     */
    public Menu createMainMenu() {
        mainMenu = new Menu();
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
}
