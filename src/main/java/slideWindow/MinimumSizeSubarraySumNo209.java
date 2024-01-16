package slideWindow;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class MinimumSizeSubarraySumNo209 {


    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};

        System.out.println(minSubArrayLen(7, nums));
    }
}
