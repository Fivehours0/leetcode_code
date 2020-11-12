package UnionFindSet;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * 输出：3
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
 */
class Union {
    private int count = 0; // 记录集的个数
    private final int[] parent;
    public Union(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        this.parent = new int[nr*nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    parent[i*nc+j] = i*nc+j;
                    count++;
                }
            }
        }
    }

    private int find(int pos) {
        /*
         * 这里的find做的是另一种路径压缩，相当于把一棵树下的所有结点都挂到根节点上
         * 与Method中所采用的路径压缩不同。
         */
        if (parent[pos] != pos)
            parent[pos] = find(parent[pos]);
        return parent[pos];
    }

    public void combine(int posX, int posY) {
        int parentX = find(posX);
        int parentY = find(posY);
        if (parentX == parentY) return;
        parent[parentX] = parentY;
        count--;
    }

    public int getCount() {
        return count;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int nc = grid[0].length;
        int nr = grid.length;
        Union union = new Union(grid);
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                int old = i * nc + j;
                if (grid[i][j] == '1') { // 只有该点位置为1时才开始union
                    grid[i][j] = '2'; // 修改的是当前位置的值，并不会修改周边位置的值
                    if (i+1<nr && grid[i+1][j]=='1') {
                        union.combine(old, (i+1)*nc+j);
                    }
                    if (i-1>=0 && grid[i-1][j]=='1') {
                        union.combine(old, (i-1)*nc+j);
                    }
                    if (j+1<nc && grid[i][j+1]=='1') {
                        union.combine(old, i*nc+j+1);
                    }
                    if (j-1>=0 && grid[i][j-1]=='1') {
                        union.combine(old, i*nc+j-1);
                    }
                }
            }
        }
        return union.getCount();
    }

    public static void main(String[] args) {
        char[][]grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }
}
