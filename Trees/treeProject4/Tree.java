package treeProject4;

import java.util.*;

public class Tree {

    TreeNode root;

    public Tree() {
    }

    public Tree(TreeNode val) {
        root = val;
    }

    public Tree(Comparable val, TreeNode left, TreeNode right) {
        root = new TreeNode(val, left, right);
    }

    public Tree(int[] x) {
        for (int i : x)
            add(i);
    }


    public void add(int val) {
        root = addHelper(root, val);
    }

    public TreeNode addHelper(TreeNode start, int val) {
        if (start == null) {
            return new TreeNode(val, null, null);
        }
        if (start.getValue().compareTo(val) > 0) {
            start.left = addHelper(start.left, val);
        } else if (start.getValue().compareTo(val) < 0) {
            start.right = addHelper(start.right, val);
        } else
            return start;

        return start;
    }

    public void remove(Comparable val) {
        root = remove(val, root);
    }

    private TreeNode remove(Comparable val, TreeNode tree) {
        if (tree != null) {
            if (val.compareTo(tree.getValue()) < 0) {
                tree.setLeft(remove(val, tree.getLeft()));
            } else if (val.compareTo(tree.getValue()) > 0) {
                tree.setRight(remove(val, tree.getRight()));
            } else {
                if (tree.getRight() == null) {
                    tree = tree.getLeft();
                } else {
                    TreeNode tmp = getMin(tree.getRight(), tree.getRight());
                    tree.setValue(tmp.getValue());
                    tree.setRight(remove(tmp.getValue(), tree.getRight()));
                }
            }
        }
        return tree;
    }

    public TreeNode getMin(TreeNode root, TreeNode min) {
        if (root != null) {
            if (root.getLeft() != null && root.getLeft().getValue().compareTo(min.getValue()) < 0) {
                min = root.getLeft();
            }
            if (root.getRight() != null && root.getRight().getValue().compareTo(min.getValue()) < 0) {
                min = root.getRight();
            }
            if (getMin(root.getLeft(), min).getValue().compareTo(getMin(root.getRight(), min).getValue()) < 0) {
                return getMin(root.getLeft(), min);
            }
            return getMin(root.getRight(), min);
        }
        return min;
    }

    /**
     * Operations
     */
    public Comparable smallest() {
        if (root.getLeft() != null)
            return smallest(root.getLeft());
        return root.getValue();
    }

    public Comparable smallest(TreeNode tree) {
        if (tree.getLeft() != null)
            return smallest(tree.getLeft());
        return tree.getValue();
    }

    public Comparable largest() {
        if (root.getRight() != null)
            return largest(root.getRight());
        return root.getValue();
    }

    public Comparable largest(TreeNode tree) {
        if (tree.getRight() != null)
            return largest(tree.getRight());
        return tree.getValue();
    }

    public int numLeaves() {
        if (root.hasNoChild())
            return 1;
        int n = 0;

        if (root.getLeft() != null)
            n += root.getLeft().countChildren();

        if (root.getRight() != null)
            n += root.getRight().countChildren();

        return n;
    }

    public int width() {
        int[] i = getDiameter(root);
        return i[0];
    }

    public static int[] getDiameter(TreeNode root) {
        int[] result = new int[]{0, 0};
        if (root == null) return result;
        int[] leftResult = getDiameter(root.getLeft());
        int[] rightResult = getDiameter(root.getRight());
        int height = Math.max(leftResult[1], rightResult[1]) + 1;
        int rootDiameter = leftResult[1] + rightResult[1] + 1;
        int leftDiameter = leftResult[0];
        int rightDiameter = rightResult[0];
        result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
        result[1] = height;

        return result;
    }

    public int numLevels() {
        int leftDiameter = getDiameter(root.getLeft())[1];
        int rightDiameter = getDiameter(root.getRight())[1];

        return 1 + Math.max(leftDiameter, rightDiameter);
    }

    public int numNodes() {
        return 1 + nodeCounter(root);
    }

    public int nodeCounter(TreeNode node) {
        if (node == null)
            return 0;
        else if (node.getLeft() != null && node.getRight() != null)
            return 2 + nodeCounter(node.getLeft()) + nodeCounter(node.getRight());
        else if (node.getLeft() == null && node.getRight() != null)
            return 1 + nodeCounter(node.getRight());
        else if (node.getRight() == null && node.getLeft() != null)
            return 1 + nodeCounter(node.getLeft());
        else
            return 0;
    }

    public boolean isFull() {
        return numNodes() == (Math.pow(2, numLevels()) - 1);
    }

    /**
     * TreeNode Nested Inner Class
     */
    public static class TreeNode {

        private Comparable value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Comparable value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public boolean hasNoChild() {
            return left == null && right == null;
        }

        public int countChildren() {
            int c = 0;

            if (hasNoChild())
                return 1;
            if (getLeft() != null)
                c += getLeft().countChildren();
            if (getRight() != null)
                c += getRight().countChildren();
            return c;
        }

        public void setValue(Comparable value) {
            this.value = value;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public Comparable getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            String accumulate = "";

            if (value == null)
                return "Value is null.";

            accumulate += getValue() + ", ";

            if (getLeft() != null)
                accumulate += getLeft().toString();

            if (getRight() != null)
                accumulate += getRight().toString();

            return accumulate;
        }

        public ArrayList<Comparable> getToString() {
            ArrayList<Comparable> accumulate = new ArrayList<>();

            if (value == null)
                return null;

            accumulate.add(getValue());

            if (getLeft() != null) {
                ArrayList<Comparable> tmp = getLeft().accumulate(accumulate);
                accumulate.addAll(tmp);
            }
            if (getRight() != null) {
                ArrayList<Comparable> tmp = getRight().accumulate(accumulate);
                accumulate.addAll(tmp);
            }

            return accumulate;
        }

        public ArrayList<Comparable> accumulate(ArrayList<Comparable> a) {
            a.add(getValue());
            if (getLeft() != null) {
                a.add(getLeft().getValue());
                a.addAll(getLeft().accumulate(a));
            }
            if (getRight() != null) {
                a.add(getRight().getValue());
                a.addAll(getRight().accumulate(a));
            }

            return a;
        }

    }

    // this is pre-order
    @Override
    public String toString() {
        String tmp = root.toString();
        return "[" + tmp.substring(0, tmp.length() - 2) + "]";
    }

    public ArrayList<Comparable> getTS() {
        ArrayList<Comparable> i = root.getToString();
        Set<Comparable> set = new HashSet<>(i);
        i.clear();
        i.addAll(set);
        return i;
    }


    public String preOrder() {
        return toString();
    }

    public String inOrder() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("[");
        ArrayList<Comparable> c = getTS();
        for (Comparable i : c) {
            tmp.append(i).append(", ");
        }
        return tmp.substring(0, tmp.length() - 2) + "]";
    }

    public String postOrderH(TreeNode tree) {
        String o = "";

        if (tree == null)
            return o;

        if (tree.getLeft() != null)
            o += postOrderH(tree.getLeft()) + ", " + tree.getLeft().getValue();

        if (tree.getRight() != null)
            o += postOrderH(tree.getRight()) + ", " + tree.getRight().getValue();


        return o;
    }

    public String postOrder() {
        return "[" + postOrderH(root).substring(2) + ", " + root.getValue() + "]";
    }

    public ArrayList<Comparable> reverse(ArrayList<Comparable> list) {
        if (list.size() > 1) {
            Comparable value = list.remove(0);
            reverse(list);
            list.add(value);
        }
        return list;
    }

    public String revOrder() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("[");
        ArrayList<Comparable> c = reverse(getTS());
        for (Comparable i : c) {
            tmp.append(i).append(", ");
        }
        return tmp.substring(0, tmp.length() - 2) + "]";
    }

    public void print() {
        String prefix = "";
        TreeNode n = root;
        if (n != null) {
            System.out.println(prefix + "\\-- " + n.value);
            print(prefix + "    ", n.left, true);
            print(prefix + "    ", n.right, false);
        }
    }

    public void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public static void main(String[] args) {
//        int[] a = {90, 50, 40, 30, 45, 65, 70, 120, 100, 95, 150};
//        int[] a = {4, 2, 1, 3, 6, 5, 7};
        int[] a = {90, 80, 70, 85, 100, 98};
        Tree one = new Tree(a);

//        one.print(); System.out.println();

        System.out.println("IN ORDER");
        System.out.println(one.inOrder());

        System.out.println("\nPRE ORDER");
        System.out.println(one.preOrder());

        System.out.println("\nPOST ORDER");
        System.out.println(one.postOrder());

        System.out.println("\nREVERSE ORDER");
        System.out.println(one.revOrder() + "\n\n");

        System.out.println("Tree width is " + one.width());
        System.out.println("Number of levels is " + one.numLevels());
        System.out.println("Smallest is " + one.smallest());
        System.out.println("Largest is " + one.largest());
        System.out.println("Number of leaves is " + one.numLeaves());
        System.out.println("Number of nodes is " + one.numNodes());
        if (one.isFull())
            System.out.println("The tree is full.");
        else if (!one.isFull())
            System.out.println("The tree is not full.");
    }

}

