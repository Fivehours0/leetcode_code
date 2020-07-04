/**
 * 哨兵, 单调栈
 */
package Code_84;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_84 {
    public static int largestRectangleArea(int[] heights) {
        int heightsLen = heights.length;
        if (heightsLen == 0) return 0;
        if (heightsLen == 1) return heights[0];

        int maxArea = 0;

        int[] newHeight = new int[heightsLen + 2];
        System.arraycopy(heights, 0, newHeight, 1, heightsLen);
        heights = newHeight;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < heightsLen + 2; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int top = stack.removeLast();
                int height = heights[top];
                int distance = i - stack.peekLast() - 1;
                int area = distance * height;
                maxArea = Math.max(maxArea, area);
            }
            stack.addLast(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 1};
        System.out.println(largestRectangleArea(heights));
    }
}
