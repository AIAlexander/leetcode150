package dynamic;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class BestTimeToBuyAndSellStock4No188 {

    /**
     * 买卖股票4，买卖股票的次数变化为k
     * 根据题目2可以得出，买卖次数如果是k时，状态为k*2个
     *      分别为 第一次持有、第一次非持有.... 第 k * 2次持有和第 k * 2次非持有
     * 递推公式：根据分析，dp数组偶数表示持有状态，dp数组奇数表示非持有状态
     *          偶数持有状态：Max(上一次持有状态，上一次非持有状态 - prices[i])
     *          奇数非持有状态：Max(上一次非持有状态，上一次持有状态 + prices[i])
     *          k == 0 的情况表示第一次持有，较为特殊，直接是 Max(上一次持有状态， -prices[i])
     *          所以递推公式dp[i][k]：
     *              当 k == 0 时：
     *                  dp[i][k] = Max(dp[i - 1][k], -prices[i]);
     *              当 k 为偶数时：
     *                  dp[i][k] = Max(dp[i - 1][k], dp[i - 1][k - 1] - prices[i]);
     *              当 k 为奇数时：
     *                  dp[i][k] = Max(dp[i - 1][k], dp[i - 1][k - 1] + prices[i]);
     * 初始化：
     *      当 k 为偶数时：
     *          dp[0][k] = -prices[i]
     *      当 k 为奇数时：
     *          dp[0][k] = 0
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int state = k * 2;
        int[][] dp = new int[prices.length][state];

        // 初始化
        for (int j = 0; j < state; j++) {
            if (j % 2 == 0) {
                // 表示持有股票状态
                dp[0][j] = -prices[0];
            } else {
                // 表示非持有股票状态
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < state; j++) {
                if (j == 0) {
                    // k = 0时，表示第一次持有股票状态
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else if (j % 2 == 0) {
                    // k 为偶数，表示持有股票状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    // k 为奇数，表示非持有股票状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][state - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock4No188 b = new BestTimeToBuyAndSellStock4No188();
        int[] nums = {3,2,6,5,0,3};
        System.out.println(b.maxProfit(3, nums));
    }
}
