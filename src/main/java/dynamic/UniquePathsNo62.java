package dynamic;

/**
 * @author wsh
 * @date 2024/8/12
 */
public class UniquePathsNo62 {

    /**
     * dp数组的含义：dp[i][j] 表示机器人从start走到(i, j)的位置的数量
     * 初始化：机器人只能往右或者往下走，因此第一行和第一列只有一种走法，因此dp[i][0] = 1; dp[0][j] = 1
     * 递归方程：机器人只能往右往下走，因此走到dp[i][j] = dp[i -1][j] + dp[i][j - 1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePathsNo62 u = new UniquePathsNo62();
        System.out.println(u.uniquePaths(3, 7));


    }
}
