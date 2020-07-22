package BinaryTree;

public class TreeNode {
    private int data;
    private TreeNode lChild;
    private TreeNode rChild;

    TreeNode() {
        this.data = 0;
        this.lChild = null;
        this.rChild = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }

    TreeNode(int data, TreeNode lChild, TreeNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return lChild;
    }

    public void setLeftChild(TreeNode lChild) {
        this.lChild = lChild;
    }

    public TreeNode getRightChild() {
        return rChild;
    }

    public void setRightChild(TreeNode rChild) {
        this.rChild = rChild;
    }
}
