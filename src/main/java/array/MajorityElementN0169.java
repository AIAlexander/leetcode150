package array;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2023/12/28
 */
public class MajorityElementN0169 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2,3,4};
        System.out.println(majorityElement(nums));
    }
}
