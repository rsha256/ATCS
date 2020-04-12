package grade;

import java.util.*;

public class StudentMap {

    /**
     * Prints the options menu and returns the letter that the user types
     * does not check for invalid selection
     *
     * @return the next token on the input stream
     */
    public static String printMenuAndGetChoice() {
        String[] gradeOptions = {"A", "B", "C", "D", "F"};
        String[] sign = {"+", "", "-"};
        Scanner input = new Scanner(System.in);
        System.out.print("Grade options: ");
        for (String letterGrade : gradeOptions)
            for (String mySign : sign)
                System.out.print(letterGrade + mySign + " ");
        System.out.print("Input Grade: ");
        return input.nextLine();
    }

    /**
     * Prints the students and grades
     *
     * @param gradeMap the map to print
     */
    public static void printGrades(Map<String, String> gradeMap) {
        System.out.println("Student Grade List");
        for (String studentName : gradeMap.keySet()) {
            System.out.println(studentName + ": " + gradeMap.get(studentName));
        }
    }

    /**
     * Modifies an entry based on user input.
     * Prints an error if an invalid student is modified
     *
     * @param gradeMap the map to modify
     */
    public static void modifyStudent(Map<String, String> gradeMap) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input student name: ");
        String studentName = input.nextLine();
        while (gradeMap.get(studentName) == null) {
            System.out.print("Student does not exist. Try again: ");
            studentName = input.nextLine();
        }
        System.out.println(studentName + ": " + gradeMap.get(studentName));
        gradeMap.put(studentName, printMenuAndGetChoice());
        printGrades(gradeMap);
    }

    /**
     * Removes a student from the map based on user input
     *
     * @param gradeMap the map to remove the student from
     */
    public static void removeStudent(Map<String, String> gradeMap) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input student name: ");
        String studentName = input.nextLine();
        while (gradeMap.get(studentName) == null) {
            System.out.print("Student does not exist. Try again: ");
            studentName = input.nextLine();
        }
        System.out.println(studentName + " is removed.");
        gradeMap.remove(studentName);
        printGrades(gradeMap);
    }

    /**
     * Adds a student based on user input. Prints an error if a student
     * is added that already exists in the map.
     *
     * @param gradeMap the map to add the student to
     */
    public static void addStudent(Map<String, String> gradeMap) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input student name: ");
        String studentName = input.nextLine();
        while (gradeMap.get(studentName) != null) {
            System.out.print("Student already exists (if 2 students have the same name, append a number to the end of one of them). Try again: ");
            studentName = input.nextLine();
        }
        System.out.println(studentName + " has been added.");
        gradeMap.put(studentName, printMenuAndGetChoice());
        printGrades(gradeMap);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("John", "B");
        map.put("Kelly", "A");
        map.put("Carl", "B+");
        map.put("Joe", "C");
        map.put("Sarah", "A");
        addStudent(map);
        System.out.println();
        modifyStudent(map);
        System.out.println();
        removeStudent(map);

    }
}
