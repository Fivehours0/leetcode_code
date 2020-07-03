/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 分析:
 * 首先分析问题，一个柱子能不能装水，看的是他两边柱子的高度。所以将大问题分解为：每个柱子能盛多少水。每个柱子能盛多少水，看的是该柱子两边的边界高度
 * 算法一: 动态规划
 * 使用动态规划，先保留每根柱子左右两边边界高度的信息，求边界高度信息也是一门学问，从左边看和从右边看，分别可以求得没根柱子的左右边界
 *
 * 算法二: 栈
 * 栈内保存的是下标信息
 * 构建单调递减栈(后一个高度小于前一个高度，入栈)，因为只有当单调后一个柱子比前一个高(递增)，才有可能形成低洼，出栈。面积=距离*高度，
 *
 * 算法三: 双指针
 * 视为一个整体，针对一个柱子，只看左指针和右指针，忽略中间。如果左右指针能形成低洼，则必能积水
 * 左右指针只记录遍历过的最大高度
 *
 */
package Code_42;

import java.util.Arrays;
import java.util.Stack;

public class Code_42 {
    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public static int DP(int[] height) {
        int ans = 0;
        int heightSize = height.length;
        int[] leftMax = new int[heightSize];
        int[] rightMax = new int[heightSize];
        if (heightSize == 0) return 0;
        leftMax[0] = height[0];
        rightMax[heightSize - 1] = height[heightSize - 1];
        for (int i = 1; i < heightSize; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for (int i = heightSize - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        for (int i = 0; i < heightSize - 1; i++) {
            int minLength = Math.min(leftMax[i], rightMax[i]);
            ans += minLength - height[i];
        }
        return ans;
    }


    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public static int doublePoint(int[] height) {
        int ans = 0;
        int heightLen = height.length;
        int left = 1;
        int right = heightLen - 2;
        if (heightLen == 0 || heightLen == 1) return 0;
        int leftBound = height[0];
        int rightBound = height[heightLen - 1];
        while (left <= right) {
            leftBound = Math.max(leftBound, height[left]);
            rightBound = Math.max(rightBound, height[right]);
            if (leftBound < rightBound) {
                ans += leftBound - height[left++];
            } else {
                ans += rightBound - height[right--];
            }
        }
        return ans;
    }

    /**
     * 堆解法
     *
     * @param height
     * @return
     */
    public static int byStack(int[] height) {
        int ans = 0;
        int heightLen = height.length;
        Stack<Integer> stack = new Stack<>();
        if (heightLen == 1 || heightLen == 0) return 0;
        stack.push(0);
        for (int i = 1; i < heightLen; i++) {
            while (height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) break;
                if (height[top] != height[stack.peek()]) {
                    int distance = i - stack.peek() - 1;
                    int bound = Math.min(height[i], height[stack.peek()]) - height[top];
                    ans += bound * distance;
                }
            }
            if (stack.empty() || height[i] < height[stack.peek()])
                stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(byStack(height));
    }
}
