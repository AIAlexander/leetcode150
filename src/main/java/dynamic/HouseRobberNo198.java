package dynamic;

/**
 * @author wsh
 * @date 2024/8/16
 */
public class HouseRobberNo198 {

    /**
     * 打家劫舍，相邻房间不能偷
     * dp数组含义：dp[i]表示i位置偷的最大钱币
     * 递推公式： dp[i] 位置的选择有两种，一种是偷当前房间，一种是不偷当前房间
     *          偷当前房间： dp[i - 2] + nums[i]，相邻的不能偷，因此i-2处的最大值
     *          不偷当前房间： dp[i - 1]
     *          所以递推公式： dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
     * 初始化：递推公式中需要初始化 dp[0]和dp[1]， dp[0] = nums[0], dp[1] = Math.max(nums[0], nums[1])
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
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobberNo198 h = new HouseRobberNo198();
        int[] nums = {1,2,3,1};
        System.out.println(h.rob(nums));
    }
}
