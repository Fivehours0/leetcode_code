package Code_105;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private final Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    private int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, 0, inorder);
    }

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 中序遍历为左根右，前序遍历为根左右，前序遍历的第一个值一定为根节点，在中序遍历中找到这个根节点值
     * 则可将中序遍历分为9|3|15，20，7的左根右结构
     * 则root(3).left = buildTree(0, 0, 9, [9,3,15,20,7])
     * 则root(3).right = buildTree(2, 4, 20, [9,3,15,20,7])
     * @param start
     * @param end
     * @param target
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int start, int end, int target, int[] inorder) {
        // 终止条件，把叶子节点也当成了根节点，叶子节点的start>end所以直接退出了递归
        if (start > end) return null;
        TreeNode root = new TreeNode(pre[target]);
        int rootPos = indexMap.get(pre[target]);
        root.left = buildTree(start, rootPos-1, target+1, inorder);
        // target+rootPos-start+1的原因
        // 针对例题中的例子：一开始，start=0，end=4，target=0得出rootPos为1
        // 则右节点的target应该为0+1-0+1=2，即值为20.
        root.right = buildTree(rootPos+1, end, target+rootPos-start+1, inorder);
        return root;
    }
}
