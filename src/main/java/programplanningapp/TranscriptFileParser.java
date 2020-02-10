package programplanningapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TranscriptFileParser {
    /**
     * Handle the parsing of the transcript file.
     *
     * @param filename The name of the file.
     * @return The parsed collection of courses
     */
    public ArrayList<CourseAttempt> parseFile(String filename) {
        Scanner scanner = null;
        String oneLine;
        CourseAttempt courseAttempt;
        ArrayList<CourseAttempt> coursesOnTranscript = new ArrayList<>();

        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                oneLine = scanner.nextLine();
                courseAttempt = parseLineIntoCourseAttempt(oneLine);
                coursesOnTranscript.add(courseAttempt);
                //System.out.println(oneLine);
            }
            scanner.close();
        } catch (Exception e) {
            //I need to return to this to make the error handling better
            System.out.println("nope");
        }

        return coursesOnTranscript;
    }

    /**
     * Handle the parsing of a line to a course attempt.
     *
     * @param line A single line to parse.
     * @return The parsed course attempt
     */
    private CourseAttempt parseLineIntoCourseAttempt(String line) {
        String[] parsedLine = line.split(",");
        CourseAttempt courseAttempt;
        String courseCode;
        Status status;
        String semester;
        int grade;

        courseCode = parsedLine[0];

        if (parsedLine[1].equals("Complete")) {
            status = Status.COMPLETE;
        } else if (parsedLine[1].equals("InProgress")) {
            status = Status.IN_PROGRESS;
        } else {
            status = Status.PLANNED;
        }

        semester = parsedLine[3];
        courseAttempt = new CourseAttempt(courseCode, status, semester);

        //Also need to put the grade if applicable
        if (status == Status.COMPLETE) {
            grade = Integer.parseInt(parsedLine[2]);
            courseAttempt.setGrade(grade);
        }

        return courseAttempt;
    }
}
