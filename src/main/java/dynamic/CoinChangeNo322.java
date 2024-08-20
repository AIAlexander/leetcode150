package dynamic;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class CoinChangeNo322 {

    /**
     * 本题求从coins取最少个零钱，使其总和为amount，零钱可以无限取
     * 完全背包问题
     * dp数组含义：dp[i] 表示总和为i最少需要dp[i]个零钱
     * 递推公式：取零钱，达到amount = i，要么取，要么不取
     *          取：dp[i - amount] + 1
     *          不取：dp[i]
     *          因此，dp[i] = Min(dp[i], dp[i - amount] + 1)
     * dp数组初始化：dp[0] = 0, 其他非0下标为Integer.Max，因为递推公式中需要取最小值，如果是0，则答案都是0
     * 遍历顺序：本题目与组合还是排列无关，因此遍历顺序无关
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        // 先遍历物品
        for (int i = 0; i < coins.length; i++) {
            // 在遍历重量
            for (int j = coins[i]; j <= amount; j++) {
                // 因为存在最大值int，如果该区域为最大值，说明当前的零花钱凑不出amount，因此需要跳过结果，否则会干扰结果
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] < 0) {
            return -1;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeNo322 c = new CoinChangeNo322();
        int[] coins = {2,5,10,1};
        System.out.println(c.coinChange(coins, 24));
    }
}
