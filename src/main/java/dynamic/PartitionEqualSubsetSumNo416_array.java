package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class PartitionEqualSubsetSumNo416_array {


    /**
     * 集合拆分成两个子集，要求两个子集的和相同
     * 该问题抽象成 0-1的背包问题，即两个子集的和为target，则转变成：
     *      子集的中的数字为重量为n，价值也为n的物品，现有target重量的背包，求该背包所装的最大价值
     *      求出最大价值之后，只要判断最大价值是否等于target，如果等于说明取得的物品，即这些数可组成一个集合，求和为target，那么剩下的集合一定也是target
     *      因为每个数字只能取一次，因此是0-1背包问题
     * 0-1背包问题使用一维动态数组求解
     * dp数组含义：dp[j] 表示当重量为j的情况下获取的最大价值
     * 递推公式：当背包为j的情况下，可以拿物品i，或者不拿物品i
     *          拿物品i：dp[j - weight[i]] + value[i]
     *          不拿物品i：dp[j]
     *          因此 dp[j] = Max(dp[j], dp[j - weight[i]] + value[i])
     * dp数组初始化：根据题意进行初始化，dp[0] = 0
     * 遍历顺序：一维数组解决0-1背包问题的遍历顺序
     *          先遍历物品，在遍历重量，原因是先遍历重量，那么dp[j]永远为0，那么dp[j]的值永远都为 dp[j - weight[i]] + value[i]，
     *          遍历重量时，需要从最大重量往后遍历，原因是如果向前遍历会重复获取之前的物品，
     *              比如 先计算dp[1], 然后dp[2]可以有dp[1]得出，也就有可能变成 dp[1] + value[1]了，那么等于是拿了拿了两遍物品1
     *
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
        int[] dp = new int[target + 1];
        dp[0] = 0;
        // 先遍历物品
        for (int i = 0; i < nums.length; i++) {
            // 再遍历重量，重量从最大重量开始遍历
            for (int j = target; j >= 0; j--) {
                // 如果当前重量能够拿i物品，那么就最大值求解，反之则取dp[j]
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[target] == sum - target;
    }


    public static void main(String[] args) {
        PartitionEqualSubsetSumNo416_array p = new PartitionEqualSubsetSumNo416_array();
        int[] nums = {1,5,11,5};
        System.out.println(p.canPartition(nums));
    }
}
