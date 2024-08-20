package dynamic;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class BestTimeToBuyAndSellStockWithCooldownNo309 {

    /**
     * 买卖股票5，可以无限次购买股票，但售出股票有冷冻期
     * 该题由买卖股票2演变过来，需要在原有状态上添加几个状态，来完整表达整个股票买卖的过程
     * dp数组含义：
     *      dp[i][0] 表示持有股票
     *      dp[i][1] 表示保持卖出股票的状态，该状态表示过完冷冻期之后，非持有股票的状态
     *      dp[i][2] 表示股票售出，该状态表示在第i天将股票售出
     *      dp[i][3] 表示冷冻期
     * 递推公式：
     *      持有股票，一种是保持上一天的状态，一种是上一天是保持卖出股票的状态，另一种是上一天是冷冻期，当天购买股票
     *          dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i])
     *      保持持有股票的状态，一种是保持上一天的状态，一种是上一天是冷冻期
     *          dp[i][1] = Max(dp[i - 1][1], dp[i - 1][3])
     *      股票卖出状态，只有在上一天持有股票时才能转变成卖出状态
     *          dp[i][2] = dp[i - 1][0] + prices[i]
     *      冷冻期，只有在上一天是股票卖出状态才是冷冻期
     *          dp[i][3] = dp[i - 1][2];
     * 初始化：
     *      dp[0][0] = -prices[0]
     *      dp[0][1] = 0;
     *      dp[0][2] = 0;
     *      dp[0][3] = 0;
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 持有股票状态
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            // 保持非持有股票状态
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 卖出股票状态
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷冻期
            dp[i][3] = dp[i - 1][2];
        }
        // 答案是：3种状态（保持非持有股票状态、卖出股票状态、冷冻期）最大值
        return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]), dp[prices.length - 1][3]);
    }

    public static void main(String[] args) {
        int[] prices = {1,4,2};
        BestTimeToBuyAndSellStockWithCooldownNo309 b = new BestTimeToBuyAndSellStockWithCooldownNo309();
        System.out.println(b.maxProfit(prices));
    }
}
