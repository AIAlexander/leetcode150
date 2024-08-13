package dynamic;

/**
 * @author wsh
 * @date 2024/8/12
 */
public class UniquePathsIINo63 {

    /**
     * 与不同路径(No.62)题目一样定义dp数组
     * 区别在于：走的路中会有石头，因此有障碍物的位置的dp数组上应该等于0，因为不能走到障碍物上
     * 初始化时注意：如果(i, 0)上有石头，那么dp[i][0] = 0，并且 (i + 1, 0).....等dp[i + 1][0] 应该也为0
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // dp初始化
        for (int i = 0; i < obstacleGrid.length; i++) {
            // grid[i][0]上有石头， 那么后面大于i的位置应该都走不到，因此都为0
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            // grid[0][j]上有石头， 那么后面大于j的位置应该都走不到，因此都为0
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                // grid上有石头
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePathsIINo63 u = new UniquePathsIINo63();
        int[][] grid = {{0, 0}, {1, 1}, {0,0}};
        System.out.println(u.uniquePathsWithObstacles(grid));
    }
}
