package treeProject7;

public class TreeNode implements Treeable {
    private Comparable treeNodeValue;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    @Override
    public Object getValue() {
        return treeNodeValue;
    }

    @Override
    public Treeable getLeft() {
        return leftTreeNode;
    }

    @Override
    public Treeable getRight() {
        return rightTreeNode;
    }

    @Override
    public void setValue(Comparable value) {
        treeNodeValue = value;
    }

    @Override
    public void setLeft(Treeable left) {
        leftTreeNode = (TreeNode) left;
    }

    @Override
    public void setRight(Treeable right) {
        rightTreeNode = (TreeNode) right;
    }

    /* Include all necessary constructors and methods below */
    public TreeNode(Comparable value, TreeNode left, TreeNode right) {
        treeNodeValue = value;
        leftTreeNode = left;
        rightTreeNode = right;
    }

//    public boolean contains(String name) {
//        ThingCount a = (ThingCount) treeNodeValue;
//        if (a.getThing().equals(name))
//            return true;
//        else if (getLeft() != null && getRight() != null)
//            return getLeft().contains(name) || getRight().contains(name);
//        else if (getLeft() != null)
//            return getLeft().contains(name);
//        else if (getRight() != null)
//            return getRight().contains(name);
//        return false;
//    }

}