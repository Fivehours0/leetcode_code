/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 */
package Code_100;

import java.util.ArrayDeque;
import java.util.Deque;

import BinaryTree.TreeNode;

public class Code_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        Deque<TreeNode> p1 = new ArrayDeque<>();
        Deque<TreeNode> q1 = new ArrayDeque<>();
        TreeNode pNode = null;
        TreeNode qNode = null;

        p1.push(p);
        q1.push(q);
        while (!p1.isEmpty()) {
            if (q1.size() != p1.size()) return false;
            pNode = p1.pop();
            qNode = q1.pop();
            if (pNode.getData() != qNode.getData()) return false;
            if (pNode.getRightChild() != null) p1.push(pNode.getRightChild());
            if (pNode.getLeftChild() != null) p1.push(pNode.getLeftChild());
            if (qNode.getRightChild() != null) q1.push(qNode.getRightChild());
            if (qNode.getLeftChild() != null) q1.push(qNode.getLeftChild());
        }
        return true;
    }

    public static void main(String[] args) {

    }
}