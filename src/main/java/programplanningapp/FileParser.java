package programplanningapp;

import java.util.ArrayList;

public interface FileParser {
    /**
     * Handle the parsing of the file.
     *
     * @param filename The name of the file.
     * @return The parsed collection of courses
     */
    ArrayList<Course> parseFile(String filename);
}
