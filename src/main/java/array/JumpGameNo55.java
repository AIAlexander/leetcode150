package array;

/**
 * @author wsh
 * @date 2024/1/3
 */
public class JumpGameNo55 {

    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,0,4};
        System.out.println(canJump(nums));
    }
}
