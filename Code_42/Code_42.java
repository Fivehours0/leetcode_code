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
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(byStack(height));
    }
}
