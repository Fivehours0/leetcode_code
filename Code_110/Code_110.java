/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 false 。
 */
package Code_110;

import BinaryTree.TreeNode;
import BinaryTree.BinaryTree;

public class Code_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(deep(root.getLeftChild(), 0) - deep(root.getRightChild(), 0)) <= 1) &&
                isBalanced(root.getLeftChild()) && isBalanced(root.getRightChild());
    }

    private int deep(TreeNode node, int index) {
        if (node == null) return index;
        return Math.max(deep(node.getLeftChild(), index + 1), deep(node.getRightChild(), index + 1));
    }

    public static void main(String[] args) {
//        int[] val = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        int[] val = {1, -1, 2, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        tree.createTree(val);
        Code_110 code_110 = new Code_110();
        System.out.println(code_110.isBalanced(tree.getRoot()));
    }
}
