package programplanningapp;

import java.util.ArrayList;

public class UploadTranscriptMenuOption implements MenuOption {
    private int value;
    private String description;
    private Menu userSubMenu;
    private Menu programOptionsMenu;
    private Student student;

    /**
     * Create the UploadTranscriptMenuOption and initialize its description.
     *
     * @param desc The description to be assigned.
     */
    public UploadTranscriptMenuOption(String desc) {
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
     * Handle the user selecting to upload a transcript.
     */
    @Override
    public void handleMenuOption() {
        InputHandler inputHandler = new InputHandler();
        TranscriptFileParser transcriptParser = new TranscriptFileParser();
        String filename;
        ArrayList<CourseAttempt> courses;
        student = new Student();

        System.out.println("Please enter the name of the file containing the transcript");
        System.out.println("The file is assumed to be in the resources directory.");
        System.out.println("For instance for transcript.csv, only enter \"transcript.csv\":");
        filename = inputHandler.getFilename();

        try {
            courses = transcriptParser.parseFile(filename);
            student.setCoursesOnTranscript(courses);
            System.out.println("You have " + student.getCoursesOnTranscript().size()
                    + " courses on your transcript.\n");

            handleUserSelectingProgram();

            createUserSubMenu();
            userSubMenu.handleMenu();
        } catch (Exception e) {
            System.out.println("The filename you provided either does not exist, "
                    + "or contains an invalid transcript file.");
            handleMenuOption();
        }
    }

    private void handleUserSelectingProgram() {
        createProgramOptionsMenu();
        programOptionsMenu.handleMenu();
    }

    private void createProgramOptionsMenu() {
        programOptionsMenu = new Menu("Please choose which program you are enrolled in:");

        for (Program program : DataUtility.getStoredPrograms()) {
            MenuOption programOption = new ProgramMenuOption(program, student);
            programOptionsMenu.addOption(programOption);
        }
        MenuOption quitOption = new QuitMenuOption("Quit");
        programOptionsMenu.addOption(quitOption);
    }

    /**
     * Create the submenu of options the user can choose from.
     */
    private void createUserSubMenu() {
        userSubMenu = new Menu("Since you have uploaded a transcript and selected your program, "
                + "you may now choose from the following options:");
        MenuOption transcriptSummary = new TranscriptSummaryMenuOption("Get Transcript Summary", student, userSubMenu);
        userSubMenu.addOption(transcriptSummary);
        MenuOption programStatus = new ProgramStatusMenuOption("Get Program Status", student, userSubMenu);
        userSubMenu.addOption(programStatus);
        MenuOption quitOption = new QuitMenuOption("Quit");
        userSubMenu.addOption(quitOption);
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
