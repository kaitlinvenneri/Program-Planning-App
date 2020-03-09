package programplanningapp;

public class ProgramMenuOption implements MenuOption {
    private int value;
    private String description;
    private Student student;
    private Program program;

    /**
     * Create the ProgramMenuOption and initialize its description.
     *
     * @param program The program associated with the menu option.
     */
    public ProgramMenuOption(Program prog, Student aStudent) {
        program = prog;
        description = prog.getName();
        student = aStudent;
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
        student.setProgram(program);
    }

    /**
     * Making a human readable toString() for the menu option.
     */
    @Override
    public String toString() {
        return description;
    }
}
