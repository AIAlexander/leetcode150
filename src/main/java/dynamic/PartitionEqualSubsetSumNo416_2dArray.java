package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class PartitionEqualSubsetSumNo416_2dArray {


    /**
     * 集合拆分成两个子集，要求两个子集的和相同
     * 该问题抽象成 0-1的背包问题，即两个子集的和为target，则转变成：
     *      子集的中的数字为重量为n，价值也为n的物品，现有target重量的背包，求该背包所装的最大价值
     *      求出最大价值之后，只要判断最大价值是否等于target，如果等于说明取得的物品，即这些数可组成一个集合，求和为target，那么剩下的集合一定也是target
     *      因为每个数字只能取一次，因此是0-1背包问题
     * 0-1背包问题使用二维动态数组求解
     * dp数组含义：dp[i][j]表示背包重量为j的情况下，从物品0-物品i获取最大价值
     * 递推公式：在(i, j)位置上，有两种选择，一种是拿weight[i]的物品，一种是不拿weight[i]的物品，两种方案取最大价值
     *      不拿weight[i]的物品，价值：dp[i - 1][j]
     *      拿了weight[i]的物品，价值：dp[i - 1][j - weight[i]] + value[i]
     *      所以 dp[i][j] = Max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
     *
     * dp数组初始化：根据题意进行初始化，即第一列dp[i][0]，由于j = 0，表示最大重量是0的情况下背包所获得最大价值，显而易见为0，因此dp[i][0] = 0
     *             第一行即dp[0][j]，表示只能物品0的时候，0-j获取的最大价值，那么当 j < 物品i的时候，最大价值为0，其余情况，最大价值为物品0的最大价值
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // 获取集合的总和，用于计算子集的总和
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }
        // 子集的总和为 sum / 2，即最大背包重量为target
        int target = sum / 2;
        // dp数组 i：物品数量，即集合中数 j：背包重量，从 0 - target
        int[][] dp = new int[nums.length][target + 1];
        // 初始化dp数组的列，dp[i][0]，表示重量为0的背包获取的最大价值，即为0
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        // 初始化dp数组的行，dp[0][j]，表示重量为0-target的背包从物品0中获取的最大价值
        for (int j = 0; j < target + 1; j++) {
            if (j >= nums[0]) {
                // 当重量超过物品0时，最大的价值为物品0的价值
                dp[0][j] = nums[0];
            } else {
                // 反之，则拿不了物品0，最大价值即为0
                dp[0][j] = 0;
            }
        }

        // 循环物品i
        for (int i = 1; i < nums.length; i++) {
            // 循环背包重量j
            for (int j = 1; j < target + 1; j++) {
                if (j - nums[i] >= 0) {
                    // 不拿物品i与拿物品i取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    // 表示背包重量j的情况下，装不了weight[i]，因此直接得出dp[i][j]为不获取物品[i]的最大价值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 最后判断背包为target所拿的最大重量，即为子集和的总和，是否等于剩下集合的总和
        return dp[nums.length - 1][target] == sum - target;
    }


    public static void main(String[] args) {
        PartitionEqualSubsetSumNo416_2dArray p = new PartitionEqualSubsetSumNo416_2dArray();
        int[] nums = {1,5,11,5};
        System.out.println(p.canPartition(nums));
    }
}
