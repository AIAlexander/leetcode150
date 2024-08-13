package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class IntegerBreakNo343 {


    /**
     * 整数拆分，固定一个乘数j，那么第i个数的另一个乘数为(i - j)
     * dp数组定义：dp[i]表示 i数值的最大乘积
     * dp数组初始化：dp[0]和dp[1]都无意义皆为0，dp[2]的最大值是1
     * 递推公式：一个整数能被任意拆分，因此固定一个值j，那么另一个值是 (i -j)，由于数是可以无限拆分的
     *          因此一个数可以拆分成 j * (i - j), 同时也可以继续拆分 (i - j)， 因此一个数的乘积也可以是 j * dp[i - j], 表示通过拆分(i - j)得到的最大值
     *          所以， dp[i] = Max(j * (i - j), j * dp[i - j], dp[i])
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            // 固定j，列举从1-i个的拆分结果
            for (int j = 1; j <= i; j++) {
                // 取 j * (i -j), j * dp[i - j], dp[i] 中的最大值
                int tmpMax = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(tmpMax, dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreakNo343 i = new IntegerBreakNo343();
        System.out.println(i.integerBreak(10));
    }
}
