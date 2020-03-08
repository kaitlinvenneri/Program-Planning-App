package programplanningapp;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utility {
    public static String getSavedCoursesFilename() {
        String separator = System.getProperty("file.separator");

        String filename = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "savedAdminCourses.csv";

        return filename;
    }


    public static ArrayList<AdminCourse> getStoredAdminCourses() {
        ArrayList<AdminCourse> storedAdminCourses = new ArrayList<>();
        CourseFileParser courseFileParser = new CourseFileParser();
        String filename;

        try {
            filename = getSavedCoursesFilename();

            storedAdminCourses = courseFileParser.parseFile(filename);
        } catch (Exception e) {
            //TODO: Improve error handling here:
            System.out.println("Something went wrong trying to get saved courses.");
        }

        return storedAdminCourses;
    }

    public static ArrayList<AdminCourse> updateStoredAdminCourses(ArrayList<AdminCourse> coursesToAdd) {
        ArrayList<AdminCourse> overwrittenCourses = new ArrayList<>();
        ArrayList<AdminCourse> savedCourses = getStoredAdminCourses();
        Boolean courseAlreadySaved;

        for (AdminCourse courseToAdd : coursesToAdd) {
            courseAlreadySaved = false;
            for (AdminCourse savedCourse : savedCourses) {
                if (courseToAdd.getCode().equals(savedCourse.getCode())) {
                    courseAlreadySaved = true;
                    overwrittenCourses.add(courseToAdd);
                    savedCourse.updateCourseInfo(courseToAdd);
                }
            }

            if (!courseAlreadySaved) {
                savedCourses.add(courseToAdd);
            }
        }

        writeCoursesToFile(savedCourses);

        return overwrittenCourses;
    }

    public static void writeCoursesToFile(ArrayList<AdminCourse> coursesToWrite) {
        String courseLine;
        PrintWriter myWriter = null;

        try {
            myWriter = new PrintWriter(new FileWriter(getSavedCoursesFilename()));

            for (AdminCourse course : coursesToWrite) {
                courseLine = "";
                courseLine = courseLine + course.getCode() + ",";
                courseLine = courseLine + course.getCredits() + ",";
                courseLine = courseLine + course.getName() + ",";

                for (int i = 0; i < course.getPrerequisiteCodes().size(); i++) {
                    courseLine = courseLine + course.getPrerequisiteCodes().get(i);

                    if (i + 1 < course.getPrerequisiteCodes().size()) {
                        courseLine = courseLine + ":";
                    }
                }
                myWriter.println(courseLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            myWriter.close();
        }
    }
}
