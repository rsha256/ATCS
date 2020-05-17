package schoolClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClubMapTester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new File("student.txt"));
        StringBuilder input = new StringBuilder();
        while (myScanner.hasNext())
            input.append(myScanner.nextLine());
        String[] studentInfo = input.toString().split("\t", -1);

        ClubMap myClubMap = new ClubMap();



    }
}
