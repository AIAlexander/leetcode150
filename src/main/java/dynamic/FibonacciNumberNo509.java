package dynamic;

/**
 * @author wsh
 * @date 2024/8/8
 */
public class FibonacciNumberNo509 {


    /**
     * dp数组的含义以及下标含义dp[i]表示：第i个斐波那契数值
     * 递推公式：dp[i] = dp[i - 1] + dp[i - 2]，即第i个数是等于 第i-1个数 + 第i-2个数
     * dp数组初始化，dp[0] = 0, dp[1] = 1
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumberNo509 f = new FibonacciNumberNo509();
        System.out.println(f.fib(6));
    }
}
