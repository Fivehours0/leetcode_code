/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 注意点（这是细节问题，首先确定出一个可行的算3数和的算法，在考虑这些问题）：
 *     不能出现重复解，则对于确定的那个数，如果遇到与上次一样的就跳过不处理
 * 在求两数之和的时候也需要注意，当遇到nums[second] == nums[second - 1]也跳过处理
 *
 * 知识点
 * 1. 双指针
 * 2. 排序
 * 3. 通过确定一个数（for循环），从而将问题退化为求两数之和（通过双指针求两数和）
 */
package Code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            if (nums[i] > 0) break;
            int second = i + 1;
            int third = numsLen - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (second < third) {
                    int target = -nums[i];
                    int sum = nums[second] + nums[third];
                    if (sum < target) second++;
                    else if (sum > target) third--;
                    else if (second == i + 1 || nums[second] != nums[second - 1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                        second++;
                        third--;
                    }
                    else second++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(Code_15.threeSum(test).toArray()));
    }
}
