package schoolClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClubMapTester {
    public static void main(String[] args) throws FileNotFoundException {
        // Build map based on data from student.txt
        Scanner myScanner = new Scanner(new File("src/schoolClub/student.txt"));
        ClubMap myClubMap = new ClubMap();

        while (myScanner.hasNext()) {
            String nextLine = myScanner.nextLine();
            String[] studentInfo=nextLine.split("\t", -1);;

            String[] s = new String[4];
            System.arraycopy(studentInfo, 0, s, 0, 4);
            Student student = new Student(s[0], s[1], s[2]);
            myClubMap.addStudent(student, s[3]);
        }

        // Prints the list for club (“Math”)
        System.out.println(myClubMap.printStudents("Math")+"\n\n");

        // Display mapping
        myClubMap.printClubs();
    }
}
