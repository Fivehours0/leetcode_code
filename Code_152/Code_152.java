package Code_152;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 思路见有道云笔记中有关dp的叙述
 */
public class Code_152 {
    public int maxProduct(int[] nums) {
        int nLen = nums.length;
        if (nLen == 1) return nums[0];
        int ans = Math.max(0, nums[0]);
        int dp1 = nums[0];
        int dp2 = nums[0];

        for (int i = 1; i < nLen; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp1 * nums[i], Math.max(nums[i], dp2 * nums[i]));
            dp2 = Math.min(dp2 * nums[i], Math.min(nums[i], tmp * nums[i]));
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }
}

