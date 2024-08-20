package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class DistinctSubsequencesNo115 {

    /**
     * 查找s中有多少个t一样的子序列，不连续
     * 比如： s = "bagg" t = "bag" 那么s[0],s[1],s[2]可以满足条件，s[0],s[1],s[3]也能满足条件，输出答案为2
     * dp数组含义：dp[i][j] 表示s串中(0 , i - 1) 最多有多少个(0 , j - 1)个t串
     * 递推公式：
     *      首先遍历到(i, j)时，不管s[i - 1] 与 t[j - 1]是否相等，base就是dp[i - 1][j]，即不考虑s[i - 1]，只考虑s[0...i - 2]与t[0...j - 1]有多少字串
     *      这个base应该一直带着
     *      随后讨论 s[i - 1] == t[j - 1]的情况下，因为两个元素相等，所以势必会多出一部分的可能
     *          多出来的部分即是dp[i - 1][j - 1]的情况，即如果不考虑s[i - 1]和t[j - 1]时，前面两个字符串能有多少字串，那么加上s[i - 1]和t[j - 1]也应该多少字串
     * 初始化: 当t = ""，s都有1个字串，因此 dp[i][0] = 1，其余均为0
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // dp[i - 1][j] 是base值，不管什么情况多需要将base值传递下去
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 如果相等的情况下，需要加上多出来的部分，多出来的部分即 dp[i - 1][j - 1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "baegg";
        String t = "b";
        DistinctSubsequencesNo115 d = new DistinctSubsequencesNo115();
        System.out.println(d.numDistinct(s, t));
    }
}
