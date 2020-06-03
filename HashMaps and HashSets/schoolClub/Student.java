package schoolClub;

public class Student implements Comparable {

    private String first, last, id;

    public Student(String first, String last, String id) {
        this.first = first;
        this.last = last;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Student sObj = (Student) o;
        if (sObj.equals(this)) {
            return 0;
        }
        if (this.getLast().equals(sObj.getLast())) {
            return this.getFirst().compareTo(sObj.getFirst());
        }
        return this.getLast().compareTo(sObj.getLast());
    }

    @Override
    public boolean equals(Object obj) {
        Student sObj = (Student) obj;
        return (sObj.getId()).equals(this.getId());
    }

    public String getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return this.getLast()+" "+this.getFirst()+" "+this.getId()+"";
    }
}
