package dynamic;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class BestTimeToBuyAndSellStock3No123 {

    /**
     * 最佳买卖股票，条件变成至多卖两次股票
     * 相比较于前两道题目，动态规划的状态多了几部分，将股票买卖的状态分成第一次持有、第一次不持有，第二次持有以及第二次不持有
     * dp数组含义：
     *      dp[i][0]：第i天第一次持有股票时最大的利润
     *      dp[i][1]：第i天第一次不持有股票时最大利润
     *      dp[i][2]：第i天第二次持有股票时最大的利润
     *      dp[i][3]：第i天第二次不持有股票时最大利润
     * 递推公式：
     *      dp[i][0]：两种选择，一种保持原有状态，一种是到i天购买了股票
     *                dp[i][0] = Max(dp[i - 1][0], -prices[i])
     *      dp[i][1]：两种选择，一种保持原有状态，一种是到i天卖出了股票
     *                dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] + prices[i])
     *      dp[i][2]：两种选择，一种保持原有状态，一种是到i天购买了股票
     *                dp[i][2] = Max(dp[i - 1][2], dp[i - 1][1] - prices[i])
     *      dp[i][3]：两种选择，一种保持原有状态，一种是到i天卖出了股票
     *                dp[i][3] = Max(dp[i - 1][3], dp[i - 1][3] + prices[i])
     * 初始化：
     *      dp[0][0] = -prices[0]; dp[0][1] = 0(可以理解为第一天买卖了股票); dp[0][2] = -prices[0]; dp[0][3] = 0;
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第一次持有股票的dp
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 第一次不持有股票的dp
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // 第二次持有股票的dp
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // 第二次不持有股票的dp
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3No123 b = new BestTimeToBuyAndSellStock3No123();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(b.maxProfit(prices));
    }
}
