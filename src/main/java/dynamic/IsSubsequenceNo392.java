package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class IsSubsequenceNo392 {


    /**
     * 求s串是否为t的子序列
     * 转化问题：求s与t的最大子序列的长度，长度如果与s相等则返回true，如果不相等返回false
     * 求解方法与No1143求最长公共子序列长度一样
     * 本题使用下标 i- 1进行求解
     * dp数组含义： dp[i][j]表示以位置 (i - 1, j- 1) 为结尾的最长公共子序列
     * 初始化： dp[i][0] 和 dp[0][j] 都是无意义的，赋值为0
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    public static void main(String[] args) {
        IsSubsequenceNo392 s = new IsSubsequenceNo392();
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(s.isSubsequence(s1, t1));
    }
}
