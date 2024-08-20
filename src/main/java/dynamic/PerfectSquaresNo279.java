package dynamic;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class PerfectSquaresNo279 {

    /**
     * 求使用最少的完全平方数加起来等于n，完全平方数可以无限取
     * 完全背包问题
     * 此题目与CoinChangeNo322一致
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquaresNo279 p = new PerfectSquaresNo279();
        System.out.println(p.numSquares(100));
    }
}
