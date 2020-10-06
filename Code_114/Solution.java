package Code_114;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 参考官方题解
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
 */
public class Solution {

//    /*
//    解法1：
//    使用前序遍历对树的每一个结点进行遍历，每遍历一个结点，就把该节点接在ans的right
//     */
//    private TreeNode ans = new TreeNode();
//    private TreeNode tmp = ans;
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        else {
//            tmp.right = new TreeNode (root.val);
//            tmp = tmp.right;
//        }
//        flatten (root.left);
//        flatten (root.right);
//        root.left = null;
//        root.right = ans.right.right;
//    }

//    /*
//    参考官方题解的方法三
//    此处用的是递归的方法，官方网站中是迭代的方法
//     */
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        if (root.right == null && root.left == null) return;
//        TreeNode left = root.left;
//        if (left != null) {
//            TreeNode tmp = left;
//            while (tmp.right != null) tmp = tmp.right;
//            tmp.right = root.right;
//            root.right = root.left;
//            root.left = null;
//        }
//        flatten (root.right);
//    }
}
