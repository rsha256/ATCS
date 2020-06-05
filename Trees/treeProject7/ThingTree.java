package treeProject7;

import java.util.ArrayList;
import java.util.Collections;

public class ThingTree {

    TreeNode root;

    public void addThing(Comparable data) {
        ThingCount thing = new ThingCount(data, 1);
        if (this.root == null)
            this.root = new TreeNode(thing, null, null);
        else if (thing.compareTo(this.root.getValue()) == 0)
            ((ThingCount) this.root.getValue()).setCount(((ThingCount) this.root.getValue()).getCount() + 1);
        else if (thing.compareTo(this.root.getValue()) < 0)
            this.root.setLeft(this.add((TreeNode) this.root.getLeft(), data));
        else
            this.root.setRight(this.add((TreeNode) this.root.getRight(), data));
    }

    private TreeNode add(TreeNode node, Comparable data) {
        ThingCount thing = new ThingCount(data, 1);
        if (node == null)
            node = new TreeNode(thing, null, null);
        else if (thing.compareTo(node.getValue()) == 0)
            ((ThingCount) node.getValue()).setCount(((ThingCount) node.getValue()).getCount() + 1);
        else if (thing.compareTo(node.getValue()) < 0)
            node.setLeft(this.add((TreeNode) node.getLeft(), data));
        else
            node.setRight(this.add((TreeNode) node.getRight(), data));
        return node;
    }

    @Override
    public String toString() {
        String input = toString(root);
        StringBuilder result = new StringBuilder();
        boolean number = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                if (number) {
                    result.append("\t");
                }
                number = false;
            } else {
                if (!number) {
                    result.append("");
                }
                number = true;
            }
            result.append(input.charAt(i));
        }
        return result.toString()+"\n";
    }

    private String toString(TreeNode tree) {
        ArrayList<String> o = new ArrayList<>();
        o.add("" + tree.getValue());
        if (tree.getLeft() != null)
            o.add(toString((TreeNode) tree.getLeft()));
        if (tree.getRight() != null)
            o.add(toString((TreeNode) tree.getRight()));
        Collections.sort(o);
        StringBuilder t = new StringBuilder();
        for (String i : o) {
            t.append(i);
        }
        return t.toString();
    }

}
