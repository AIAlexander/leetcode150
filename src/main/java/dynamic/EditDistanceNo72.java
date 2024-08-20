package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class EditDistanceNo72 {

    /**
     * 编辑距离，求操作多少步骤能使word1和word2相同
     * 操作有：增、删、替
     * 该题目与N0583删除操作让两个单词相同思路一样，只不过在No583中，不考虑两个元素时需要删除两次才可以，本题目可以使用替换操作，因此只需要操作一次，其余都相同
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistanceNo72 e = new EditDistanceNo72();
        System.out.println(e.minDistance("horse", "ros"));
    }
}
