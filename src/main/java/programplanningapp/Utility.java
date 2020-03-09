package programplanningapp;

import java.io.File;
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
        File savedCoursesFile;

        try {
            filename = getSavedCoursesFilename();

            savedCoursesFile = new File(filename);

            if (savedCoursesFile.exists()) {
                storedAdminCourses = courseFileParser.parseFile(filename);
            }
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
            myWriter = new PrintWriter(new FileWriter(new File(getSavedCoursesFilename())));

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

    public static String getSavedProgramsDirectory() {
        String separator = System.getProperty("file.separator");

        String folderName = "." + separator + "src" + separator + "main"
                + separator + "resources" + separator + "savedPrograms";

        return folderName;
    }

    public static ArrayList<Program> getStoredPrograms() {
        ArrayList<Program> storedPrograms = new ArrayList<>();
        ProgramFileParser programFileParser = new ProgramFileParser();
        File folder;
        String filename;
        ArrayList<String> filenames = new ArrayList<>();
        String separator = System.getProperty("file.separator");

        try {
            folder = new File(getSavedProgramsDirectory());

            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    filename = getSavedProgramsDirectory() + separator + listOfFiles[i].getName();
                    //System.out.println(filename);
                    filenames.add(filename);
                }
            }

            for (String nameOfFile : filenames) {
                storedPrograms.add(programFileParser.parseFile(nameOfFile));
            }
        } catch (Exception e) {
            //TODO: Improve error handling here:
            System.out.println("Something went wrong trying to get saved programs.");
        }
        return storedPrograms;
    }

    public static ArrayList<Program> updateStoredPrograms(Program programToAdd) {
        ArrayList<Program> overwrittenPrograms = new ArrayList<>();
        ArrayList<Program> savedPrograms = getStoredPrograms();
        Boolean programAlreadySaved = false;

        for (Program savedProgram : savedPrograms) {
            if (programToAdd.getName().equals(savedProgram.getName())) {
                programAlreadySaved = true;
                overwrittenPrograms.add(programToAdd);
                savedProgram.setRequiredCoursesByName(programToAdd.getRequiredCoursesByName());
            }
        }

        if (!programAlreadySaved) {
            savedPrograms.add(programToAdd);
        }

        writeProgramsToFile(savedPrograms);

        return overwrittenPrograms;
    }

    public static void writeProgramsToFile(ArrayList<Program> programsToWrite) {
        String programLine;
        PrintWriter myWriter = null;

        try {
            for (Program program : programsToWrite) {
                //File fileToSaveTo = new File(getProgramFilename(program.getName()));
//                if (fileToSaveTo.createNewFile()) {
//                    System.out.println("File created: " + fileToSaveTo.getName());
//                } else {
//                    System.out.println("File already exists.");
//                }

                myWriter = new PrintWriter(new FileWriter(new File(getProgramFilename(program.getName()))));

                programLine = "";
                programLine = programLine + program.getName() + ",";

                for (int i = 0; i < program.getRequiredCoursesByName().size(); i++) {
                    programLine = programLine + program.getRequiredCoursesByName().get(i);

                    if (i + 1 < program.getRequiredCoursesByName().size()) {
                        programLine = programLine + ",";
                    }
                }
                myWriter.println(programLine);
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            myWriter.close();
        }
    }

    public static String getProgramFilename(String programName) {
        String separator = System.getProperty("file.separator");
        return getSavedProgramsDirectory() + separator + programName + ".csv";
    }
}
