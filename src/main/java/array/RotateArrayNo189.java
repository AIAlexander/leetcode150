package array;

/**
 * @author wsh
 * @date 2024/1/3
 */
public class RotateArrayNo189 {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        rotate(nums, 2);
        System.out.println(nums);
    }
}
