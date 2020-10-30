package Code_79;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 细节：
 *  1.暂时将数组元素改变为'/'来区分该元素已经被使用过，退出递归的时候在改回来
 *  2.由于程序中一直在用charAt，这个效率有点慢，所以事先将String转化为char[]
 */


class Solution {
    private int width = 0;
    private int len = 0;
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        this.width = board[0].length;
        this.len = board.length;
        for (int i = 0; i < this.len; i++) {
            for (int j = 0; j < this.width; j++) {
                if (exist(board, words, 0, j, i)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] word, int pos, int x, int y) {
        if (pos == word.length) return true;
        if (!isPosLegal(x, y)) return false;
        if (board[y][x] == word[pos]) {
            char tmp = board[y][x];
            board[y][x] = '/';
            boolean ans = exist(board, word, pos + 1, x + 1, y) ||
                    exist(board, word, pos + 1, x - 1, y) ||
                    exist(board, word, pos + 1, x, y + 1) ||
                    exist(board, word, pos + 1, x, y - 1);
            board[y][x] = tmp;
            if (ans) return true;
        }
        return false;
    }

    private boolean isPosLegal(int x, int y) {
        if (x < 0 || x >= this.width) return false;
        if (y < 0 || y >= this.len) return false;
        return true;
    }
}