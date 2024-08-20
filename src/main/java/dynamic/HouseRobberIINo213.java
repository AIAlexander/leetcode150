package dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/8/16
 */
public class HouseRobberIINo213 {

    /**
     * 打家劫舍2，此时nums数组为环形，同样相邻的不能偷取
     * 比如： num[0] 和 num[num.length - 1]就不能同时被偷
     * 题目重点是将环形问题转换为线性问题，我们可以使用踢出元素的方式将环形问题转为线性问题
     *      情况1：考虑nums[0]的房间，不考虑nums[length - 1]的房间
     *      情况2：考虑nums[length - 1]的房间，不考虑nums[0]的房间
     *      情况3：nums[0]、nums[length - 1]的房间都不考虑
     * 情况1和情况2其实都包括了情况3，因此只需情况1，情况2
     * 那么只需要用No198的解题方法，传入了两个不同的数组，最终取最大值即可
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robSub(Arrays.copyOfRange(nums, 0, nums.length - 1)), robSub(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robSub(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobberIINo213 h = new HouseRobberIINo213();
        int[] num = {2,3,2};
        System.out.println(h.rob(num));
    }
}
