package dynamic;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class CombinationSumIVNo377 {

    /**
     * 与coinChangeNo518相类似，只不过本题求的是排列，因此遍历顺序有所不同
     * 完全背包问题
     * dp数组含义：dp[i]表示总和为i的最多方法
     * 递推公式: dp[i] += dp[i - nums[j]]
     * 遍历顺序：遍历重量，再遍历物品，可以求出不同的排列，如{1,2}和{2,1}是两种不同的集合
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 遍历重量
        for (int i = 0; i <= target; i++) {
            // 遍历物品
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIVNo377 c = new CombinationSumIVNo377();
        int[] nums = {1,2,3};
        System.out.println(c.combinationSum4(nums, 4));
    }
}
