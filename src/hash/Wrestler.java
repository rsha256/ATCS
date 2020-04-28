package hash;

public class Wrestler {
    private String name;
    private int weight;

    public Wrestler(String theName, int theWeight) {
        name = theName;
        weight = theWeight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int compareTo(Object cmpTo) {
        if(getWeight() != ((Wrestler) cmpTo).getWeight())
            return getWeight() - ((Wrestler) cmpTo).getWeight();
        else
            return getName().compareTo(((Wrestler) cmpTo).getName());
    }

    @Override
    public boolean equals(Object obj) {
        return compareTo(obj) == 0;
    }

    @Override
    public int hashCode() {
        return (getWeight() - 100)/10;
    }

    @Override
    public String toString() {
        return name + " " + weight;
    }
}
