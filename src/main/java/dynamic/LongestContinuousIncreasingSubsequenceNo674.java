package dynamic;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class LongestContinuousIncreasingSubsequenceNo674 {

    /**
     * 最长递增连续子序列，需要注意的是连续
     * dp数组含义：dp[i]以i为结尾最长的递增连续子序列的长度
     * 递推公式：
     *      dp[i]只有当nums[i] > nums[i - 1]，表示以位置i-1为结尾的递增子序列能包含位置i的元素，组成长度+1的递增连续子序列。如果小于，那么i位置的最长递增子序列长度为1
     *      if (nums[i] > nums[i - 1]) dp[i] = dp[i] + 1
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i - 1] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequenceNo674 l = new LongestContinuousIncreasingSubsequenceNo674();
        int[] nums = {1,3,5,4,7};
        System.out.println(l.findLengthOfLCIS(nums));
    }
}
