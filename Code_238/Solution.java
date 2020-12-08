package Code_238;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 *
 * 本来空间复杂度为n，即需要数组left=[1,1,2,6] right=[24,12,4,1]，ans[i]=left[i]*right[i]，即ans=[24,12,8,6]
 *
 * 本答案通过遍历两次的方式，将空间复杂度优化至常数空间，第一遍ans中的结果为left遍历，第二遍ans中的结果为left遍历乘上right遍历。
 * 让我想到了之前的一道困难题，接接雨水。
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = p;
            p *= nums[i];
        }

        for (int i = nums.length-1; i >= 0; i--) {
            ans[i] *= q;
            q *=nums[i];
        }
        return ans;
    }
}
