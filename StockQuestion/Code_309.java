package StockQuestion;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */

public class Code_309 {
    public int maxProfit(int[] prices) {
        int pLen = prices.length;
        if (pLen == 0 || pLen == 1) return 0;
        int statusNum = 3; // 0表示无股票，1表示持有，2表示冻结
        int[][] dp = new int[pLen][statusNum];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < pLen; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }

        return Math.max(dp[pLen-1][0], Math.max(dp[pLen-1][1], dp[pLen-1][2]));
    }

    public static void main(String[] args) {
        int[] test = {7,1,5,3,6,4};
        Code_309 s = new Code_309();
        System.out.println(s.maxProfit(test));
    }
}