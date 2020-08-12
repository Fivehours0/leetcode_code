package interview_10_01;

import java.util.Arrays;

/**
 *
 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

 初始化 A 和 B 的元素数量分别为 m 和 n。

 示例:

 输入:
 A = [1,2,3,0,0,0], m = 3
 B = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 说明:

 A.length == n + m

 逆向双指针：
    正向的双指针在插入时，会覆盖掉A中的元素
 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int left = m - 1, right = n - 1;
        while (left >= 0 || right >= 0) {
            if (left < 0) {
                A[left + right + 1] = B[right--];
                continue;
            }

            if (right < 0) {
                A[left + right + 1] = A[left--];
                continue;
            }
            if (A[left] >= B[right]) A[left + right + 1] = A[left--];
            else A[left + right + 1] = B[right--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {4,5,6,0,0,0};
        int[] B = {1,2,3};
        s.merge(A, 3, B,3);
        System.out.println(Arrays.toString(A));
    }
}
