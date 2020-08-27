package StockQuestion;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */

public class Code_188 {
    public int maxProfit(int k, int[] prices) {
        int pLen = prices.length;
        if (pLen == 0 || pLen == 1) return 0;

        //当k非常大时转为无限次交易
        if(k>=pLen-1) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<pLen;++i) {
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }

        int statusNum = 2*k+1; // 状态数
        int[] dp = new int[statusNum];
        dp[0] = 0;
        for (int i = 0; i < statusNum; i++) {
            if (i % 2 == 0) dp[i] = 0;
            else dp[i] = -prices[0];
        }

        for (int i = 0; i < pLen; i++) {
            for (int j = 1; j < statusNum; j++) {
                if (j % 2 == 0) dp[j] = Math.max(dp[j], dp[j-1] + prices[i]);
                else dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
            }
        }

        int ans = 0;
        for (int i = 1; i < statusNum; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {2,4,1};
        Code_188 s = new Code_188();
        System.out.println(s.maxProfit(2, test));
    }
}
