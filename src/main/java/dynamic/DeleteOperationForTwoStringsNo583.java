package dynamic;

/**
 * @author wsh
 * @date 2024/8/19
 */
public class DeleteOperationForTwoStringsNo583 {

    /**
     * 求最少需要删除多少个元素，来让word1和word2相等
     * dp数组含义：dp[i][j] 表示以[i - 1]末尾的word1和以[j - 1]末尾的word2最少需要删除多少元素来使得word1和word2相等
     * 递推公式：
     *      当 word1[i - 1] == word2[j - 1]
     *          两个元素相等，表示不需要删除word1[i - 1]和word2[j - 1]的元素，因此 dp[i][j] = dp[i - 1][j - 1]
     *      当 word1[i - 1] != word2[j - 1]
     *          两个元素不相等，那会有三种情况
     *              1。不考虑word1[i - 1], 那么 word1[0...i - 2]和word2[0...i - 1]的情况下，最小需要删除多少个元素，即dp[i - 1][j]
     *                 知道了dp[i - 1][j]之后，那么再把word1[i - 1]这个元素删了即可满足条件。因此 dp[i][j] = dp[i - 1][j] + 1
     *              2。同理，不考虑word2[j - 1]的情况，因此 dp[i][j] = dp[i][j - 1] + 1
     *              3。两者都不考虑的情况下，那么去掉两个元素的最少次数，即dp[i - 1][j - 1],这种情况下，需要操作2次，将两个元素都删了
     *                 因此 dp[i][j] = dp[i - 1][j - 1] + 2
     *          因此3种情况都能满足条件，题目要求求最小值，因此3种情况选最小值即可
     *          dp[i][j] = Min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2)
     * 初始化：当word1为""时，那么word2中有多少个元素，就需要删除多少次，即dp[0][j] = j， 同理：dp[i][0] = i;
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
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
                    // 元素不相等，三种方式选取一种删除元素最少的
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStringsNo583 d = new DeleteOperationForTwoStringsNo583();
        System.out.println(d.minDistance("sea", "eat"));
    }
}
