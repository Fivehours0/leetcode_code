/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *思路
 *
 *三指针
 *1. 使用左指针left和右指针right分别表示滑动窗口的左右边界
 *2. 使用最大值指针max指向当前的最大值
 *
 *流程
 *1. left++, right++
 *2. 更新max
 *3. 将max指针位置的值写入结果数组ans中
 *
 *哨兵
 *将left, right, max分别初始化为-1, k-2, -1的方式实现
 *如果将left, right, max分别初始化为0, k-1, 0, 是无法从始至终使用上述流程的
 *
 *更新max的2种情况
 *1. 随着左边界的迭代, max溜出滑动窗口的范围, 即left > max
 *2. 随着右边界的迭代, 右边新加入的值大于max位置的值
 */

package swordOffer59_I;

import java.util.Arrays;

public class Solution {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int numLen = nums.length;
        if (numLen == 0) return new int[0];
        int[] ans = new int[numLen - k + 1]; // 保存结果
        int left = -1; // 左指针
        int right = k - 2; // 右指针
        int max = left; // 最大值指针

        while (right < numLen - 1) {
            left++;
            right++;
            if (max < left) { // 更新最大值
                max = left;
                for (int i = left; i <= right; i++) {
                    max = nums[max] < nums[i] ? i : max;
                }
            }
            max = nums[max] < nums[right] ? right : max; // 更新最大值
            ans[left] = nums[max];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
