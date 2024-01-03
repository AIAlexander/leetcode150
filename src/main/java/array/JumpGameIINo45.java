package array;

/**
 * @author wsh
 * @date 2024/1/3
 */
public class JumpGameIINo45 {


    public static int jump(int[] nums) {
        int maxIndex = 0;
        int step = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (end == i) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,2,3};
        System.out.println(jump(nums));
    }
}
