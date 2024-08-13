package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class TargetSumNo494 {

    /**
     * 此题求目标和，可以给数字添加'+' 和 '-'符号，使得和为target
     * 可以将集合分成两堆，一堆是'+'，一堆是'-'，'+'堆为left，'-'堆为right
     * 所以 left + right = sum; left - right = target，因此left= (target + sum) / 2
     * 问题就转变成nums分成和为left的子集有多少种分发
     *
     * 再进一步转化，转化成0-1背包问题，即重量为left的背包，装满left背包有几种方法，因此此问题是0-1背包中装满target有几种方法
     * dp数组含义：dp[i]为重量为i时，有几种方法能使背包重量为i
     * 递推公式：
     *      当前背包里面有重量为nums[0]时，那么剩下的重量为left - nums[0]，剩下的重量装满的方法为 dp[left - nums[0]]
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int weight = (target + sum) / 2;
        int[] dp = new int[weight + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = weight; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[weight];
    }

    public static void main(String[] args) {
        int[] nums = {100};
        TargetSumNo494 t = new TargetSumNo494();
        System.out.println(t.findTargetSumWays(nums, 0));
    }
}
