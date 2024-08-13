package dynamic;

/**
 * @author wsh
 * @date 2024/8/8
 */
public class ClimbingStairsNo70 {

    /**
     * 爬楼梯问题，一次性爬1或2步
     * dp数组以及下标含义dp[i]：表示走到i阶楼梯有多少种方法
     * 递推公式：因为一次性可以走1，2步，如果要走到第三阶，可以先走到第一阶，也可以先走到第二阶，因此走到第三阶的方法应该就是 走到第一阶的方法 + 走到第二阶的方法
     *      所以： dp[i] = dp[i - 2] + dp[i - 1]
     * dp数组初始化，根据含义可以得出 dp[1] = 1, dp[2] = 2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairsNo70 c = new ClimbingStairsNo70();
        System.out.println(c.climbStairs(4));
    }
}
