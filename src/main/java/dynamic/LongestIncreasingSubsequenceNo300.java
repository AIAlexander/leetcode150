package dynamic;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class LongestIncreasingSubsequenceNo300 {

    /**
     * 输出递增子序列的最大长度
     * dp数组的含义：dp[i] 表示以位置i作为结尾的递增子序列的最大长度
     * 递推公式：在0-i下标的子数组中，需要定义一个j，当num[i] > num[j]时，说明 以j结尾的递增子序列能与i组合成一个更长的子序列。并且求最大值，因此dp[i]应该都需要取最大值
     *              所以：dp[i] = Max(dp[j] + 1, dp[i])
     * 初始化：1个数组就能组合成1个长度为1的子序列，因此dp数组都初始化为1
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // dp数组表示以位置i作为结尾的递增子序列，因此答案应该是在0 - nums.length - 1之间取最大dp
            // 在此处进行最大结果的保持
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceNo300 l = new LongestIncreasingSubsequenceNo300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS(nums));
    }
}
