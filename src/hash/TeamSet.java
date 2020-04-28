package hash;

import java.util.HashSet;
import java.util.Iterator;

public class TeamSet {
    private HashSet<Wrestler> wrestSet;

    public TeamSet() {
        wrestSet = new HashSet<Wrestler>();
    }

    public void addWrestler(Wrestler wrestler) {
        if (wrestSet.contains(wrestler)) {
            System.out.println("!!**\tCannot add " + wrestler.getName() + " with weight " + wrestler.getWeight() +
                    ",\n\tsince he is already in this set.");
            return;
        }
        wrestSet.add(wrestler);
    }

    public void removeWrestler(Wrestler wrestler) {
        if (!wrestSet.contains(wrestler)) {
            System.out.println("!!**\tCannot remove " + wrestler.getName() + " with weight " + wrestler.getWeight() +
                    ",\n\tsince he is not in this set.");
            return;
        }
        wrestSet.remove(wrestler);
    }

    public double avgWeight() {
        double total = 0;
        for (Wrestler wrestler : wrestSet) {
            total += wrestler.getWeight();
        }
        return total / wrestSet.size();
    }

    public String lightweight() {
        StringBuilder lightWeights = new StringBuilder("[");
        for (Wrestler wrestler : wrestSet) {
            if (wrestler.getWeight() < 120)
                lightWeights.append(wrestler).append(", ");
        }
        return lightWeights.substring(0, lightWeights.length() - 2) + "]";
    }

    public String toString() {
        if (wrestSet.isEmpty())
            return "";
        StringBuilder wrestlers = new StringBuilder();
        for (Wrestler wrestler : wrestSet) {
            wrestlers.append(wrestler).append(", ");
        }
        return wrestlers.substring(0, wrestlers.length() - 2);
    }

    public HashSet<Wrestler> getWrestSet() {
        return wrestSet;
    }
}
