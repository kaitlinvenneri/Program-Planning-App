package programplanningapp;

import java.util.Scanner;

public class InputHandler {
    /**
     * Create the InputHandler.
     */
    public InputHandler() {
    }

    /**
     * Get a filename from the user.
     *
     * @return the name of the file provided by the user
     */
    public String getFilename() {
        int command = 0;
        System.out.println("> ");
        Scanner scanner = new Scanner(System.in);
        String filename;
        String separator = System.getProperty("file.separator");
//        filename = "./src/main/resources/" + scanner.nextLine();
        filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + scanner.nextLine();

        return filename;
    }


    /**
     * Get a command from the user and convert to an int.
     *
     * @return the users command converted to an int
     */
    public int getCommand() {
        //TODO: Improve Error handling here too
        int command = 0;
        System.out.println("> ");
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        inputLine = scanner.nextLine();

        String[] parsedInput = inputLine.split(" ");
        if (parsedInput.length == 0 || parsedInput.length > 1) {
            //don't want more than one integer as a command, or none
            command = 0;
        } else if (inputLine == null || inputLine.isEmpty()) {
            command = 0;
        } else {
            boolean nonDigit = false;
            //check for null and string length of 0?
            for (char c : inputLine.toCharArray()) {
                if (!Character.isDigit(c)) {
                    nonDigit = true;
                }
            }

            if (nonDigit) {
                command = 0;
            } else {
                command = Integer.parseInt(inputLine);
            }
        }

        return command;
    }

    /**
     * Handle the command according to the menu provided.
     *
     * @param menu Menu for command to be processed for.
     * @param command Value of command to be processed.
     */
    public void processCommand(Menu menu, int command) {
        MenuOption option;

        if (menu.hasOption(command)) {
            option = menu.getMenuOptionByValue(command);
            option.handleMenuOption();
        } else {
            //TODO: Add Error handling in a better way
            //At the moment, the program just ends if not provided a valid input
            System.out.println("\n" + menu.getNonOptionMessage());
        }
    }
}
