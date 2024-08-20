package dynamic;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class CoinChangeIINo518 {

    /**
     * 从集合中找出零钱，加起来等于amount，零钱可以无限取
     * 看到零钱无限取，就说明该问题是完全背包问题
     * dp数组含义：dp[i] 表示凑成总和为i的组合有多少种
     * 递推公式:  凑成总和为i的方法可以是 i - coins[0], i - coins[1]...，因此这些方法加起来即是凑成i的所有方法
     *          dp[i] += dp[i - coins[j]]
     * dp数组初始化: dp[0] = 1，dp[0]必须是1，否则累加出来都会是0
     * 遍历顺序：完全背包的遍历顺序，因为本题计算有几种方法
     *          如果先遍历重量，再遍历物品，会有重复的集合，如{1,2}和{2, 1}
     *          如果先遍历物品，在遍历重量，则不会存在重复的集合
     *          本题遍历的顺序应该是先是物品，再是重量
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChangeIINo518 o = new CoinChangeIINo518();
        System.out.println(o.change(5, coins));
    }
}
