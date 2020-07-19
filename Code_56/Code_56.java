/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * knowledge：
 * 1.使用二维数组
 * 2.先排序（可以理解为对数据进行预处理）
 *
 * 按每个数组的0索引位置进行排序，这样就可以保证可以合并的区间一定是连续的。
 */
package Code_56;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Code_56 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i+1][0]) {
                right = Math.max(right, intervals[++i][1]);
            }
            res.add(new int[] {left, right});
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(test)));
    }
}
