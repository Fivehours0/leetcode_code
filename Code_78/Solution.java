package Code_78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 思路：
 *  利用动态规划的思想，值为1的时候添加不添加两种选择：[], [1]
 *  值为2的时候添加不添加两种选择: [] [1] [2] [1, 2]
 */
class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(0, nums);
        return ans;
    }

    private void subsets(int start, int[] nums) {
        // 难点2：直接在start==num.length时才将结果添加进ans。如果在中间过程种添加，难度大大增加
        // 这和动态规划的思路有点像，都是在递归到最后的时候才考虑结果
        if (start == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        subsets(start+1, nums);
        tmp.add(nums[start]);
        subsets(start+1, nums);
        // 难点1：这个tmp的改变会影响每一层递归层，所以，在递归返回的时候要进行remove，将加入tmp的值remove掉
        tmp.remove(tmp.size()-1);
    }
}
