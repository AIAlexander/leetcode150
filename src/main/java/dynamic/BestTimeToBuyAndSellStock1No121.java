package dynamic;

/**
 * @author wsh
 * @date 2024/8/16
 */
public class BestTimeToBuyAndSellStock1No121 {

    /**
     * 买卖股票问题，一次只能买卖一个股票
     * 使用动态规划二维dp数组解决股票类问题
     * dp数组含义： dp[i][0]表示第i天持有股票时的最大金额，dp[i][1]表示第i天不持有股票时的最大金额
     * 递推公式：
     *          1。持有股票时的最大金额
     *                  一种状态是保持现状：dp[i][0] = dp[i - 1][0]
     *                  一种状态是之前没有持有股票，在i天购买了当天的股票： dp[i][0] = -price[i];
     *             因此持有股票时的dp： dp[i][0] = max(dp[i - 1][0], -price)
     *
     *          2。不持有股票时的最大金额
     *                  一种状态时保持现状：dp[i][1] = dp[i - 1][1]
     *                  一种是之前有股票，在i天将其卖出： dp[i][1] = dp[i - 1][0] + price[i]
     *             因此不持有股票时的dp：dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + price[i])
     * 初始化：需要初始化dp[0][0]和dp[0][1]
     *              dp[0][0] 表示持有股票，因此dp[0][0] = -price[0];
     *              dp[1][1] 表示不持有股票，因此dp[0][1] = 0;
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 持有该股票的dp
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 不持有该股票的dp
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock1No121 b = new BestTimeToBuyAndSellStock1No121();
        System.out.println(b.maxProfit(prices));
    }
}
