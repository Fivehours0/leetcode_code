package Code_300;

import java.util.ArrayList;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {
    // 动态规划。dp数组保存的是位置i处上升子序列最大长度
    /*
        10,9,2,5,3,7,101,18
      dp 1 1 1 2 2
        到7的时候。3比7小，dp值为2. 5同理也为2. 2同理为1。 则最大的dp值为2，
        也就是说，7前面能组成的最大上升序列为2个，则7的dp值为3
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) return 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }

        int max = 1;
        for (int value : dp) {
            max = Math.max(value, max);
        }
        return max;
    }

    // 动态规划 + 二分法。
    /*
        10,9,2,5,3,7,101,18
        i在7处时，dp数组的内容为2 3 7
        因为10，9，2中只能组成长度为1的序列，而2最小，所以dp[0]=2
        2,5,3中能组成长度为2的序列分别为2，5和2，3. 没轮到3的时候dp[1]=5，但是3同样组成长度为2的序列，且比5小则dp[1]=3
        假设dp=[2,5,6,8], 若出现4
     */
    public int lengthOfLISDP2(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        if (nums.length == 0) return 0;
        dp.add(nums[0]);
        for (int num: nums) {
            if (num > dp.get(dp.size()-1)) {
                dp.add(num);
            } else if (num < dp.get(0)) {
                dp.set(0, num);
            } else {
                int pos = dichotomy(dp, num);
                dp.set(pos, num);
            }
        }
        return dp.size();
    }

    private int dichotomy (ArrayList<Integer> nums, int target) {
        int right = nums.size() - 1, left = 0;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] test = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLISDP2(test));
    }
}
