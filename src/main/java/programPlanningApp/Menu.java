package programplanningapp;

import java.util.LinkedList;

public class Menu {
    private LinkedList<MenuOption> menuOptions;

    /**
     * Create the menu and initialize the menuOptions.
     */
    public Menu() {
        menuOptions = new LinkedList<MenuOption>();
    }

    /**
     * Get the menu option from the provided value.
     *
     * @param value Value associated with a menu option.
     * @return The menu option.
     */
    public MenuOption getMenuOptionByValue(int value) {
        MenuOption option = null;
        for (MenuOption opt : menuOptions) {
            if (opt.getMenuOptionValue() == value) {
                option = opt;
            }
        }
        return option;
    }

    /**
     * Get the menu option from the provided description.
     *
     * @param description Description associated with a menu option.
     * @return The menu option.
     */
    public MenuOption getMenuOptionByDescription(String description) {
        MenuOption option = null;
        for (MenuOption opt : menuOptions) {
            if (opt.getMenuOptionDescription().equals(description)) {
                option = opt;
            }
        }
        return option;
    }

    /**
     * Check if an option exists that corresponds with the option provided.
     *
     * @param option Value possibly associated with a menu option.
     * @return True if option is contained in the menu. False otherwise.
     */
    public boolean hasOption(int option) {
        //menu options start at 1
        if (option >= 0 && option <= menuOptions.size()) {
            return true;
        }
        return false;
    }

    /**
     * Provide the message for when an option is not in a menu.
     *
     * @return Message for non-option.
     */
    public String nonOptionMessage() {
        return "Please enter the number corresponding to the menu option that you would like to select.";
    }

    /**
     * Add a MenuOption to the menu.
     *
     * @param option MenuOption to be added to the menu.
     */
    public void addOption(MenuOption option) {
        int optionValue = menuOptions.size() + 1;
        option.setMenuOptionValue(optionValue);
        menuOptions.add(option);
    }

    /**
     * Making a human readable toString() for the menu.
     */
    @Override
    public String toString() {
        String menuString = "";
        int currOption = 0;
        for (int i = 0; i < menuOptions.size(); i++) {
            currOption = i + 1;
            menuString += currOption + ": " + menuOptions.get(i).toString() + "\n";
        }
        return menuString;
    }
}
