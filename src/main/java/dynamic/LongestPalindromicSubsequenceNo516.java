package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class LongestPalindromicSubsequenceNo516 {


    /**
     * 查找字符串s中最长回文子序列，子序列可以不连续
     * 该题目与No647寻找最长回文字串有所不同的是，该子序列能够不连续，而且本题目求的是长度
     * dp数组含义：dp[i][j] 表示[i, j]字串中的最长回文子序列的长度
     * 递推公式：根据回文字串的特性，即一头一尾的元素相同时，如果去掉两个元素，里面的子序列也是回文的话，那么长度就相加
     *         而且题目是可以不连续，因此 dp[i][j] = dp[i + 1][j - 1] + 2
     *         如果 str[i] == str[j]:
     *              dp[i][j] = dp[i + 1][j - 1] + 2;
     *         如果 str[i] != str[j]:
     *              因为可以不连续，当分别排除str[i]、str[j]时的最长回文子序列的长度就是当前字串的最长回文字串
     *              比如： b b a  i=0, j =2时， str[0] != str[3]， 那么就应该取 [b b] 和 [b a] 的最长子序列长度，因此b b a的 dp = 2
     *              所以： dp[i][j] = Max(dp[i + 1][j], dp[i][j - 1])
     * 初始化：当i，j相等时，即i，j指向同一个元素时，子序列长度为1
     * 遍历顺序：从递推公式看，dp[i + 1][j - 1]，因此需要往右上方向推，因此 i从大到小，j从i+1开始，从小到大
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            // 因为dp[i][j], i,j相同时已经初始化，因此j从i+1处遍历
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 答案在右上角，因为递推的方向是从左下到右上的
        // 从dp含义处理解，dp[0][length] 表示[0, length]情况下最长回文子序列，也是符合dp的定义
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequenceNo516 l = new LongestPalindromicSubsequenceNo516();
        System.out.println(l.longestPalindromeSubseq("bbbbab"));
    }
}
