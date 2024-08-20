package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class MaximumSubarrayNo53 {

    /**
     * 求数组中连续子序列的最大和
     * dp数组含义：dp[i]以i为结尾的最大连续子序列的和
     * 递推公式：dp[i]的最大连续子序列的和能通过dp[i - 1] + nums[i]推的
     *         但是有可能当前的元素nums[i] > dp[i - 1] + nums[i]，这种情况下就应该抛弃到之前的子序列和，从当前元素重新开始计算和
     *         dp[i] = Max(dp[i - 1] + nums[i], nums[i])
     * 初始化：dp[0] 即为第一个元素 dp[0] = nums[0];
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 将每次计算出来的最大子序列和保持下来
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarrayNo53 m = new MaximumSubarrayNo53();
        System.out.println(m.maxSubArray(nums));
    }
}
