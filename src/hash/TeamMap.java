package hash;

import java.util.HashMap;
import java.util.Set;

public class TeamMap {

    private HashMap<Integer, TeamSet> wrestMap;

    public TeamMap() {
        wrestMap = new HashMap<Integer, TeamSet>();
        for (int i = 0; i <= 9; i++)
            wrestMap.put(i, new TeamSet());
    }

    public void addWrestler(Wrestler bob) {
        wrestMap.get(bob.hashCode()).addWrestler(bob);
    }

    public void changeWeightGroup(Wrestler juan, int i) {
        if (juan.hashCode() > i) {
            System.out.println("!!\t" + juan.getName() + " is too heavy for weight group " + i + ".");
            return;
        }
        wrestMap.get(juan.hashCode()).removeWrestler(juan);
        wrestMap.get(i).addWrestler(juan);
    }

    public int getWeightGroup(Wrestler juan) {
        for (int i = 0; i <= 9; i++) {
            if (wrestMap.get(i).getWrestSet().contains(juan))
                return i;
        }
        return -1;
    }

    public void changeWeight(Wrestler juan, int i) {
        wrestMap.get(juan.hashCode()).removeWrestler(juan);
        juan.setWeight(i);
        wrestMap.get((i - 100) / 10).addWrestler(juan);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            output.append("Group ").append(i).append(" ").append(wrestMap.get(i)).append("\n");
        }
        return output.toString();
    }


}
