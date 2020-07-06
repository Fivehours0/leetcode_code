/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 思路
 * 每个柱子都能勾勒出矩形，勾勒出的面积大小取决于该柱子的左右边界，比如柱子5的左边界是数字1，有边界是数字2
 * 要找到柱子的左边界，只需要构建一个单调递增的栈即可，当遇到比当前柱子高度低的柱子(右边界)的时候，则出栈并计算勾勒出的面积
 *
 * 添加左哨兵，不需要注意栈为空
 * 添加右哨兵，因为只有当遇到比栈顶元素小的柱子高度时，才会出栈，所以不添加右哨兵(值为0)的话，栈内可能还有元素存留，需要另行处理
 *
 * 知识点
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
