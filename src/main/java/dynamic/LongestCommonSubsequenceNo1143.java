package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class LongestCommonSubsequenceNo1143 {

    /**
     * 求出两个字符串最长子序列的长度，不需要连续
     * 区别于No718求最长重复子数组，该题目的子序列不需要重复
     * dp含义：dp[i][j]表示以i，j结尾的最长公共子序列
     * 递推公式：同样 当text1 == text2时，dp[i][j] = dp[i - 1][j - 1] + 1，
     *         但是text1 ！= text2时，因为可以不连续，所以dp[i - 1][j]可能是当前状态下最长公共子序列，dp[i][j - 1]可能是当前状态下最长公共子序列
     *         比如：abc 和 abe，c和e不相同，那么abc和abe的公共子序列的长度：可能是 abc和ab的最大长度，也可能是ab和abe的最大长度
     *         所以：
     *              if (text1 == text2) {
     *                  dp[i][j] = dp[i - 1][j - 1] + 1;
     *              } else {
     *                  dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1])
     *              }
     * 初始化：因满足不连续的情况，那么只有当某个元素与第一个元素相同，那么后续的位置应该都初始化为1
     *        比如 abcde 和 a，那么后续不管是ab、abc...他们的dp应该都为1
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }
        // 初始化，如果存在字符串相等，那么后续的都应该相等
        for (int i = 1; i < text1.length(); i++) {
            dp[i][0] = dp[i - 1][0];
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < text2.length(); j++) {
            dp[0][j] = dp[0][j - 1];
            if (text2.charAt(j) == text1.charAt(0)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // 相等情况，通过dp[i - 1][j - 1]推出
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，考虑到不连续性，那么应该取dp[i - 1][j], dp[i][j - 1]的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 因为dp[i][j] 相等情况下是加一，不相等的情况取最大值，所以最后一格的就是两个数组的公共子序列长度
        return dp[text1.length() - 1][text2.length() - 1];
    }


    public static void main(String[] args) {
        LongestCommonSubsequenceNo1143 l = new LongestCommonSubsequenceNo1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(l.longestCommonSubsequence(text1, text2));
    }
}
