package dynamic;

/**
 * @author wsh
 * @date 2024/8/8
 */
public class MinCostClimbingStairsNo746 {


    /**
     * cost数组为爬到某一阶所花费的体力
     * dp数组以及下标含义dp[i]: 表示走到i层花费的最小体力
     * 递推公式：首次一次只能走1或2步，因此走到第i层可以从i-1层走也可以从i-2层走。
     *         题目中说明到达i层是不需要花费cost[i]的体力值，比如到达第4个台阶所花费的最小体力是 Min（dp[2] + cost[2], dp[3] + cost[3]）
     *         因此递推公式为：
     *              dp[i] = Min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
     * dp数组初始化：
     *         题目中说明到达i层不需要花费体力值，并且我可以选择从0和1的位置开始走，因此 dp[0] = 0, dp[1] = 0
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i -2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        MinCostClimbingStairsNo746 m  = new MinCostClimbingStairsNo746();
        int[] cost = {1, 100, 1,1,1,100,1,1,100,1};
        System.out.println(m.minCostClimbingStairs(cost));
    }
}
