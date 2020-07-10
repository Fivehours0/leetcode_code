package Code_11;

public class Code_11 {
    public static int maxArea(int[] height) {
        int heightLen = height.length;
        int left = 0;
        int right = heightLen - 1;
        int maxArea = 0;
        while (left != right) {
            int distance = right - left;
            int leftBound = height[left];
            int rightBound = height[right];

            int bound = Math.min(leftBound,rightBound);
            maxArea = Math.max(maxArea, bound * distance);
            if (leftBound < rightBound) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}
