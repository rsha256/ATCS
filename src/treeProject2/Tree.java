package treeProject2;

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

    public boolean find(Comparable obj) {
        int o = (Integer) obj;
        if (this.root == null)
            return false;
        else if (o == this.root.getValue())
            return true;
        else if (o < this.root.getValue())
            return this.find(o, this.root.getLeft());
        else
            return this.find(o, this.root.getRight());
    }

    public boolean find(int object, Node node) {
        if (node == null)
            return false;
        else if (object == node.getValue())
            return true;
        else if (object < node.getValue())
            return this.find(object, node.getLeft());
        else
            return this.find(object, node.getRight());
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
        bt.add(14);
        bt.add(15);
        bt.add(21);
        System.out.println(bt);
        System.out.println("3 exists: " + bt.find(3));
        System.out.println("6 exists: " + bt.find(6));
        System.out.println("14 exists: " + bt.find(14));
    }

}
