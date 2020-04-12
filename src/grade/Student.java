package grade;

public class Student implements Comparable {
    private String lastName;
    private String firstName;
    private int studentID;

    public Student() {
        lastName = "";
        firstName = "";
        studentID = 0;
    }

    public Student(String lastName, String firstName, int studentID) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public int compareTo(Object obj) {
        Student tmp = (Student) obj;
        if (!this.lastName.equalsIgnoreCase(tmp.lastName))
            return this.lastName.compareTo(tmp.lastName);
        else if (!this.firstName.equalsIgnoreCase(tmp.firstName))
            return this.firstName.compareTo(tmp.firstName);
        return this.studentID - tmp.studentID;
    }

    @Override
    public int hashCode() {
        return studentID;
    }

    public boolean equals(Student obj) {
        return (obj.toString()).equals(this.toString());
    }

    public String toString() {
        return lastName + ", " + firstName + "\t\t\t" + studentID;
    }
}
