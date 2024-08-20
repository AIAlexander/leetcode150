package dynamic;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class OnesAndZeroesNo474 {

    /**
     * 找出最大集合，满足集合中0的数量为m，1的数量为n个
     * 问题可转化为0-1背包问题，即背包重量多了一层纬度，既要满足m，又要满足n
     *
     * dp数组含义：dp[i][j]表示 i个0，j个1的情况下元素的最大数量
     * 递推公式：从集合中获取元素，面临两种选择，取与不取
     *          不取：dp[i][j]
     *          取：dp[i - x][j - y] + 1 ，x，y表示取当前元素，元素包含x个0和y个1
     *          所以递推公式： dp[i][j] = Max(dp[i][j], dp[i - x][j - y] + 1)
     * 遍历顺序，先物品后重量，重量从大到小遍历
     * dp数组初始化：dp[0][0] = 0，表示满足0个0，0个1的情况下，物品数量为0
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        // 遍历物品
        for (int i = 0; i < strs.length; i++) {
            // 获取物品中0，1的数量
            int x = 0;
            int y = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    x++;
                } else {
                    y++;
                }
            }
            // 遍历重量
            for (int j = m; j >= x; j--) {
                for (int k = n; k >= y; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - x][k - y] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroesNo474 o = new OnesAndZeroesNo474();
        String[] strs = {"10","1","0"};
        System.out.println(o.findMaxForm(strs, 1, 1));
    }
}
