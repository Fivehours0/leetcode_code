package Code_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 难点之一：
 *  如何表示该数字已经被用过了：
 *      法1：建立一个boolean类型的数组，用过的在该数组内标true
 *      法2：原地交换数字的位置，将用过的数据放在左边，没用的放在右边(即下面的方法，depth正好为左右分界，
 *          然后for从depth开始)
 *      法3：将nums中的数据写入HashSet中，用过的数就丢掉，HashSet作为形参传入下一次递归(效率不高)
 *          使用增强型for对HashSet进行遍历时，不能remove(因为remove之后迭代器发生了变化，会报错)，
 *          正确的做法是，重新new HashSet(oldSet), 然后remove
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        permute(0, nums.length, set);
        return ans;
    }

    private void permute(int depth, int len, ArrayList<Integer> set) {
        if (depth == len) {
            ans.add(new ArrayList<>(set));
            return;
        }

        for (int i = depth; i < len; i++) {
            Collections.swap(set, i, depth);
            permute(depth+1, len, set);
            Collections.swap(set, i, depth);
        }
    }
}
