package Code_287;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 */
public class Code_287 {
    /**
     * 二分法
     * @param nums data
     * @return the repeat number
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1; int right = n;
        int mid = (left + right) / 2;

        while (left != right) {
            int count = 0;
            for (int num: nums) {
                if (num <= mid) count++;
            }
            if (count > mid) right = mid;
            else left = mid+1;
            mid = (left + right) / 2;
        }
        return mid;
    }

    /**
     * 也可以用快慢指针的思维来理解这道题目
     * 与题目环形链表2类似
     * 举例{1, 3, 4, 2, 2}
     * 0->1  1->3  2->4  3->2  4->2
     * 0->1->3->2->4->2->4....形成了环
     * 参考链接 https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     * @param nums
     */
    public int method1 (int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 4, 2, 2};
        Code_287 c = new Code_287();
        System.out.println(c.method1(test));
    }
}
