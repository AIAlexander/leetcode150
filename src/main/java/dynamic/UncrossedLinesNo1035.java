package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class UncrossedLinesNo1035 {

    /**
     * 本题目查找两个数组连线，并且不能出现交叉线
     * 分析：不能形成交叉线，说明两个数组中相同的元素需要保持顺序
     *      比如：[1,4,2] 和 [1,2,4] 如果连了4和4，那么2和2就无法相连
     *      因此本题目就可以转变为 求两个数组的公共子序列
     * 解题思路与No1143求最长公共子序列长度相同
     * 递推公式：
     *      if(nums[i] == nums[j]) {
     *          dp[i][j] = dp[i - 1][j - 1] + 1;
     *      } else {
     *          dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1])
     *      }
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        if (nums1[0] == nums2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < nums1.length; i++) {
            dp[i][0] = dp[i - 1][0];
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < nums2.length; j++) {
            dp[0][j] = dp[0][j - 1];
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length - 1][nums2.length - 1];
    }
}
