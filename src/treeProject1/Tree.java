package treeProject1;

public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(int val, Node left, Node right) {
        root = new Node(val, left, right);
    }

    public void add(int val) {
        root = addHelper(root, val);
    }

    public Node addHelper(Node start, int val) {
        if (start == null) {
            return new Node(val, null, null);
        }
        if (start.getValue() > val) {
            start.left = addHelper(start.left, val);
        } else if (start.getValue() < val) {
            start.right = addHelper(start.right, val);
        } else
            return start;

        return start;
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "Value:" + getValue();
        }
    }


    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    @Override
    public String toString() {
        print("", root, false);
        return "";
    }

    public static void main(String[] args) {
        Node l = new Node(1, new Node(0, null, null), new Node(2, null, null));
        Node r = new Node(7, new Node(5, null, null), new Node(10, null, null));
        Tree bt = new Tree(3, l, r);
        bt.add(6);
        bt.add(8);
        System.out.println(bt);
    }

}
