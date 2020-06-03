package grade;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentGrades2 {
    /**
     * Prints the options menu and returns the letter that the user types does not check for
     * invalid selection
     *
     * @return the next token on the input stream
     */
    public static String printMenuAndGetChoice() {
        String[] gradeOptions = {"A", "B", "C", "D", "F"};
        String[] sign = {"+", "-", ""};
        Scanner input = new Scanner(System.in);
        System.out.print("Grades Options: ");
        for (String myGrade : gradeOptions)
            for (String mySign : sign)
                System.out.print(myGrade + mySign + " ");
        System.out.println("\nEnter letter grade: ");
        return input.nextLine();
    }

    /**
     * Prints the students and grades
     *
     * @param gradeMap the map to print
     */
    public static void printGrades(Map<Student, String> gradeMap) {
        System.out.println("STUDENT LIST\t\tID\t GRADE");
        for (Student myStudent : gradeMap.keySet()) {
            System.out.println(myStudent + ": " + gradeMap.get(myStudent));
        }
    }

    /**
     * Modifies an entry based on user input. Prints an error if an invalid student is
     * modified
     *
     * @param studentToGradeMap the map to modify
     * @param idToStudentMap    the map to associate student id with a student
     */
    public static void modifyStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
        Scanner input = new Scanner(System.in);
        int ID = 0;
        int x = 0;
        do {
            System.out.println("Enter the ID of the student to modify: ");
            ID = input.nextInt();

            if (idToStudentMap.get(ID) == null) {
                System.out.println("Can not modify - there is no student with that ID");
                x = 1;
                break;
            }
            System.out.println();
        } while (idToStudentMap.get(ID) == null);
        if (x == 0) {
            System.out.println(idToStudentMap.get(ID) + " has a " + studentToGradeMap.get(idToStudentMap.get(ID)));
            studentToGradeMap.put(idToStudentMap.get(ID), printMenuAndGetChoice());
        }
    }

    /**
     * Removes a student from the map based on user input
     *
     * @param studentToGradeMap the map to remove the student from
     * @param idToStudentMap    the map to associate student id with a student
     */
    public static void removeStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
        Scanner input = new Scanner(System.in);
        int ID = 0;
        int x = 0;
        do {
            System.out.print("Enter the ID of the student to remove: ");
            ID = input.nextInt();

            if (idToStudentMap.get(ID) == null) {
                System.out.print("The student does not exist! Try again!");
                x = 1;
                break;
            }
            System.out.println();
        } while (idToStudentMap.get(ID) == null);
        if (x == 0) {
            System.out.println(idToStudentMap.get(ID) + " has been removed.");
            studentToGradeMap.remove(idToStudentMap.get(ID));
        }
    }

    /**
     * Adds a student based on user input. Prints an error if a student
     * is added that already exists in the map.
     *
     * @param studentToGradeMap the map to add the student to
     * @param idToStudentMap    the map to associate student id with a student
     */
    public static void addStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap) {
        Scanner input = new Scanner(System.in);
        Student student = null;
        boolean loop = false;
        do {
            System.out.println("Please enter first name: ");
            String firstName = input.nextLine();
            System.out.println("Please enter last name: ");
            String lastName = input.nextLine();
            System.out.println("Please enter ID: ");
            int ID = input.nextInt();
            input.nextLine();

            student = new Student(lastName, firstName, ID);
            if (idToStudentMap.get(student.getStudentID()) != null) {
                System.out.println("That student ID is already in use.\nPlease try again.");
                loop = !loop;
                break;
            } else
                idToStudentMap.put(student.getStudentID(), student);
            System.out.println();
        } while (loop);
        if (!loop)
            studentToGradeMap.put(student, printMenuAndGetChoice());
    }

    public static void main(String[] args) {
        Map<Student, String> map = new TreeMap<>();
        Map<Integer, Student> IDs = new TreeMap<>();
        Scanner keyboard = new Scanner(System.in);

        String response;
        do {
            System.out.println("What would you like to do?");
            System.out.println("A)dd a student\n" +
                    "R)emove a student\n" + "M)odify Grades\n" +
                    "P)rint all grades\n" + "Q)uit");
            System.out.println("Enter your choice: ");
            response = keyboard.nextLine().toUpperCase().substring(0, 1);

            switch (response) {
                case "A":
                    addStudent(map, IDs);
                    break;
                case "R":
                    removeStudent(map, IDs);
                    break;
                case "M":
                    modifyStudent(map, IDs);
                    break;
                case "P":
                    printGrades(map);
                    break;
            }
            System.out.println();
        } while (!response.equals("Q"));
    }
}
