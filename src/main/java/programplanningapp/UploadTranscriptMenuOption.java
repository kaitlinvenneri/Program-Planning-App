package programplanningapp;

import java.util.ArrayList;

public class UploadTranscriptMenuOption implements MenuOption {
    private int value;
    private String description;
    private Menu userSubMenu;
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
        courses = transcriptParser.parseFile(filename);
        student.setCoursesOnTranscript(courses);

//        for (Course course : student.getCoursesOnTranscript()) {
//            System.out.println(course.toString());
//        }

        System.out.println("You have " + student.getCoursesOnTranscript().size() + " courses on your transcript.\n");

        createUserSubMenu();
        System.out.print(userSubMenu.toString());

        int command = inputHandler.getCommand();
        inputHandler.processCommand(userSubMenu, command);
    }

    /**
     * Create the submenu of options the user can choose from.
     */
    private void createUserSubMenu() {
        userSubMenu = new Menu("Since you have uploaded a transcript, you may now choose from the following options:");
        MenuOption transcriptSummary = new TranscriptSummaryMenuOption("Get Transcript Summary", student);
        userSubMenu.addOption(transcriptSummary);
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
