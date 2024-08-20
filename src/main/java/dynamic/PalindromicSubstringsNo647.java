package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class PalindromicSubstringsNo647 {

    /**
     * 计算s中有多少个回文字串，需要连续
     * dp数组含义：dp[i][j] 表示[i,j]字串中有多少个回文字串
     * 递推公式：
     *          i从大到小，j从i到末尾
     *          如果 s[i] == s[j]，有以下几种情况
     *              (1) j - i <= 1, 即 同时指向一个元素，或者元素长度为2，如aa，那么该情况是回文字串，因此dp[i][j] = true，并且结果加1
     *              (2) j - i > 1, 那就要判断dp[i + 1][j - 1]这个区间是否是回文字串，如果这个区间是，那么dp[i][j] = true,并且结果加1
     * 遍历顺序：
     *      递推公式中，dp[i][j] 是通过 dp[i + 1][j - 1]推倒获取的，因此i从大到小遍历，j从小到大遍历，并且j要从i位置处，从小到大遍历
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstringsNo647 p = new PalindromicSubstringsNo647();
        System.out.println(p.countSubstrings("anna"));
    }
}
