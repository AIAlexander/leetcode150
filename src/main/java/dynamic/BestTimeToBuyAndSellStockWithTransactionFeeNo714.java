package dynamic;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class BestTimeToBuyAndSellStockWithTransactionFeeNo714 {

    /**
     * 买卖股票6，在买卖股票2的基础上添加了手续费，即交易一次需要支付手续费
     * 区别在于 非持有股票时，卖出股票时需要减去手续费，即
     *      dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee)
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有股票状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 非持有股票状态
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFeeNo714 b = new BestTimeToBuyAndSellStockWithTransactionFeeNo714();
        int[] prices = {1,3,2,8,4,9};
        System.out.println(b.maxProfit(prices, 2));
    }
}
