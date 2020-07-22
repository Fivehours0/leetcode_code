package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree {
    private TreeNode root = null;
    private int index = 0;

    /**
     * create binary tree
     * @param nums data added to tree
     * @return root node
     */
    public TreeNode createTree (int[] nums) {
        if (nums[this.index] == -1) {
            this.index++;
            return null;
        }
        TreeNode TreeNode = new TreeNode(nums[this.index++]);
        if (this.root == null) this.root = TreeNode;
        TreeNode.setLeftChild(this.createTree(nums));
        TreeNode.setRightChild(this.createTree(nums));
        return TreeNode;
    }

    /**
     * 先序遍历, 递归
     */
    public void preOrder () {
        this.preOrder(root);
    }

    public void preOrder (TreeNode node) {
        if (node == null) return;
        System.out.print(node.getData());
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    /**
     * 中序遍历, 递归
     */
    public void inOrder () {
        this.inOrder(root);
    }

    public void inOrder (TreeNode node) {
        if (node == null) return;
        inOrder(node.getLeftChild());
        System.out.print(node.getData());
        inOrder(node.getRightChild());
    }

    /**
     * 后序遍历, 递归
     */
    public void lastOrder () {
        this.lastOrder(root);
    }

    public void lastOrder (TreeNode node) {
        if (node == null) return;
        lastOrder(node.getLeftChild());
        lastOrder(node.getRightChild());
        System.out.print(node.getData());
    }

    /**
     * 先序遍历，使用栈
     */
    public void preOrderStack () {
        preOrderStack(root);
    }

    public void preOrderStack (TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            System.out.print(parent.getData());
            if (parent.getRightChild() != null) {
                stack.push(parent.getRightChild());
            }
            if (parent.getLeftChild() != null) {
                stack.push(parent.getLeftChild());
            }
        }
    }

    /**
     * 中序遍历，使用栈
     */
    public void inOrderStack () {
        inOrderStack(root);
    }

    public void inOrderStack (TreeNode node) {
        if (node == null) return ;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            while (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
                node = node.getLeftChild();
            }
            TreeNode parent = stack.pop();
            System.out.print(parent.getData());
            if (parent.getRightChild() != null) {
                stack.push(parent.getRightChild());
                node = parent.getRightChild();
            }
        }
    }

    /**
     * 后序遍历，使用栈
     */
    public void lastOrderStack () {
        lastOrderStack(root);
    }

    public void lastOrderStack (TreeNode node) {
        if (node == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode record = null; // 记录之前访问过的结点
        stack.push(node);
        while (!stack.isEmpty()) {
            while (node.getLeftChild() != null) {
                if (node.getRightChild() != null)
                    stack.push(node.getRightChild());
                stack.push(node.getLeftChild());
                node = node.getLeftChild();
            } if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
                node = node.getRightChild();
            }

            TreeNode parent = stack.pop();
            if (parent.getLeftChild() == null && parent.getRightChild() == null) {
                System.out.print(parent.getData());
                record = parent;
            } else if (record != null && (parent.getRightChild() == record || parent.getLeftChild() == record)) {
                System.out.print(parent.getData());
                record = parent;
            } else {
                stack.push(parent);
                node = parent;
            }
        }
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 4, 7, -1, -1, 8, -1, -1, -1, 3, 5, -1, 9, -1, -1, 6, -1, -1};
//        int[] test = {1, -1, 2, 3, -1, -1, -1};
        BinaryTree tree = new BinaryTree();
        tree.createTree(test);
//        tree.preOrderStack();
        tree.inOrderStack();
//        tree.lastOrderStack();
//        tree.preOrder();
        tree.inOrder();
//        tree.lastOrder();
    }
}