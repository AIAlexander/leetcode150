package greedy;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class JumpGameNo55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i , cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameNo55 j = new JumpGameNo55();
        int[] nums = {2, 0};

        System.out.println(j.canJump(nums));
    }
}
