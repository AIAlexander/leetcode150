package dynamic;

/**
 * @author wsh
 * @date 2024/8/18
 */
public class MaximumLengthOfRepeatedSubarrayNo718 {

    /**
     * 查找两个数组的最长重复子数组，需要连续
     * 本题使用二维数组dp
     * dp数组含义：dp[i][j] 表示以 nums1[i] 和 nums2[j]的数组最长重复子数组
     * 递推公式：本题强调连续的子数组，那么当nums[i]等于nums[j]时，dp[i][j]只能通过dp[i - 1][j - 1]推出来
     *          如果当nums[i]不等于nums[j]，那么说明当前两个子数组不能构成最长子数组，因此为0
     *          if (nums[i] == nums[j]) dp[i][j] = dp[i - 1][j - 1] + 1
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int res = 0;
        // 初始化，如果第一行有相等的值，那就初始化为1
        for (int j = 0; j < nums2.length; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
            }
            res = Math.max(dp[0][j], res);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            }
            res = Math.max(dp[i][0], res);
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // dp是以i、j结尾两个数组的最长重复子数组，因此不一定是最后一个i，j为最长，因此每次都要保存一个最大值
                res = Math.max(dp[i][j], res);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,8};
        int[] nums2 = {5,6,1,4,7};

        MaximumLengthOfRepeatedSubarrayNo718 m = new MaximumLengthOfRepeatedSubarrayNo718();
        System.out.println(m.findLength(nums1, nums2));
    }
}
