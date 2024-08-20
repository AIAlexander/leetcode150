package dynamic;

/**
 * @author wsh
 * @date 2024/8/16
 */
public class BestTimeToBuyAndSellStock2No122 {

    /**
     * 买卖股票2，股票可以买卖多次
     * 区别于No121 买卖股票1，解题的思路都一样，区别在于递推公式中的dp[i][0]
     * 此时dp[i][0] 的两种情况为：一种购买当天股票，一种保持原状
     *          保持原状：dp[i][0] = dp[i - 1][0]
     *          购买当天股票: dp[i][0] = dp[i - 1][1] - prices[i], 区别在此，因为可以多次买卖股票，因此是用前一天非持有股票时的金额去购买
     *          而No121题目中只能买卖一次，则在购买股票时，最大金额肯定是0，因此直接就是dp[i][0] = -prices[i]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有股票的dp公式相较于No121有所变化
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
