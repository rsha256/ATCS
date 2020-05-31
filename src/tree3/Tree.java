package tree3;

// remove BST
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

    public TreeNode getRoot() {
        return root;
    }

    public static class TreeNode {

        private Comparable value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Comparable value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
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

    }

    @Override
    public String toString() {
        String tmp = root.toString();
        return "[" + tmp.substring(0, tmp.length() - 2) + "]";
    }

    public void print() {
        String prefix = "";
        TreeNode n = root;
        boolean isLeft = false;
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
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
        int[] a = {10, 2, 12, 1, 7, 5, 4, 6, 8, 15, 19};
        Tree one = new Tree(a);
        System.out.println(one);
        one.remove(1);

        System.out.println(one);
    }

}
