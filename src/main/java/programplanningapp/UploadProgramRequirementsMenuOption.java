package programplanningapp;

import java.util.ArrayList;

public class UploadProgramRequirementsMenuOption implements MenuOption {
    private int value;
    private String description;

    /**
     * Create the UploadProgramRequirementsMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public UploadProgramRequirementsMenuOption(String desc) {
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
        ProgramFileParser programFileParser = new ProgramFileParser();
        String filename;
        Program program;
        ArrayList<Program> overwrittenPrograms;

        System.out.println("Please enter the name of the file containing the program to be added");
        System.out.println("The file is assumed to be in the resources directory.");
        System.out.println("For instance for computingGeneralProgram.csv, only enter \"computingGeneralProgram.csv\":");
        filename = inputHandler.getFilename();
        try {
            program = programFileParser.parseFile(filename);

            overwrittenPrograms = Utility.updateStoredPrograms(program);

            if (overwrittenPrograms.size() > 0) {
                System.out.println("\nNo new programs were added.");
                System.out.println("\nThe following progam has been overwritten with the following data: ");
            } else {
                System.out.println("You have input the following program: ");
            }

            System.out.println("\nProgram name: " + program.getName() + "\n");
            System.out.println("Required Courses: ");
            for (String courseName : program.getRequiredCoursesByName()) {
                System.out.println(courseName);
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
