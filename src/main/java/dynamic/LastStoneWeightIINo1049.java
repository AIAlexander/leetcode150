package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class LastStoneWeightIINo1049 {

    /**
     * 将石头分成两堆，尽量让两堆的差值更接近，两堆的差值就是结果
     * 此问题可以抽象成0-1背包问题，重量为target为sum / 2，数组中的石头重量为stones[i], 价值也为stones[i]，
     *      那么获取的最大值为dp[n]，那么另一堆石头的和为 sum - dp[n]，两堆的差值就是答案
     * 通过一维数组解决
     * dp的数组含义：背包为i重量时获取的最大价值
     * 递推公式：dp[i] = Max(dp[i], dp[i - weight[i]] + value[i])
     * 遍历顺序：先遍历物品，在遍历重量，重量从大到小遍历
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        // sum - dp[target]是另一堆的总和，dp[target]是一个堆的总和，两个差为答案
        return Math.abs(sum - dp[target] - dp[target]);
    }

    public static void main(String[] args) {
        LastStoneWeightIINo1049 l = new LastStoneWeightIINo1049();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(l.lastStoneWeightII(stones));
    }
}
