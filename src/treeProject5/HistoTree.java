package treeProject5;

import static java.lang.System.*;

public class HistoTree {
    private HistoNode root;

    public HistoTree() {
        root = null;
    }

    public void addData(Comparable data) {
        root = add(data, root);
    }

    private HistoNode add(Comparable data, HistoNode tree) {
        if (tree == null)
            return new HistoNode(data, 1, null, null);

        if (tree.getData().compareTo(data) > 0) {
            tree.setLeft(add(data, tree.getLeft()));
        } else if (tree.getData().compareTo(data) < 0) {
            tree.setRight(add(data, tree.getRight()));
        } else if (tree.getData().compareTo(data) == 0) {
            tree.setDataCount(tree.getDataCount() + 1);
        } else
            return tree;

        return tree;
    }

    public HistoNode search(Comparable data) {
        return search(data, root);
    }

    private HistoNode search(Comparable data, HistoNode tree) {
        HistoNode h = null;
        if ((tree.getData()).compareTo((data)) == 0)
            return tree;
        else if (tree.getLeft() != null && tree.getRight() != null) {
            HistoNode t = search(data, tree.getLeft());
            if (t != null)
                h = t;
            t = search(data, tree.getRight());
            if (t != null)
                h = t;
        } else if (tree.getLeft() == null && tree.getRight() != null) {
            HistoNode t = search(data, tree.getRight());
            if (t != null)
                h = t;
        } else if (tree.getRight() == null && tree.getLeft() != null) {
            HistoNode t = search(data, tree.getLeft());
            if (t != null)
                h = t;
        }
        return h;
    }

    public String toString() {
        output = "";
        return toString(root);
    }

    static String output = "";

    private String toString(HistoNode tree) {
        String prefix = "";
        if (tree != null) {
            output += (prefix + "\\-- " + tree.getData()) + "\n";
            print(prefix + "    ", tree.getLeft(), true);
            print(prefix + "    ", tree.getRight(), false);
        }
        return output;
    }

    public void print(String prefix, HistoNode n, boolean isLeft) {
        if (n != null) {
            output += (prefix + (isLeft ? "|-- " : "\\-- ") + n.getData()) + "\n";
            print(prefix + (isLeft ? "|   " : "    "), n.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), n.getRight(), false);
        }
    }
}
