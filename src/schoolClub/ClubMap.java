package schoolClub;

import java.util.*;

public class ClubMap {
    private HashMap<String, HashSet<Student>> clubList;

    public ClubMap() {
        clubList = new HashMap<>();
    }

    public void addStudent(Student toBeAdded, String whichClub) {
        this.clubList.computeIfAbsent(whichClub, k -> new HashSet<>());

        this.clubList.get(whichClub).add(toBeAdded);
    }

    public String printStudents(String whichClub) {
        StringBuilder tmp = new StringBuilder(whichClub + ": ");
        for (Student student : clubList.get(whichClub)) {
            tmp.append(student).append(" ");
        }
        return tmp.toString();
    }

    public void printClubs() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String tmp = "";
        for (Map.Entry<String, HashSet<Student>> entry : clubList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return tmp;
    }
}
