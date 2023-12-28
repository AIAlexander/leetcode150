package array;

/**
 * @author wsh
 * @date 2023/12/28
 */
public class RemoveElementNo27 {

    /**
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     */
    public static int removeElement(int[] nums, int val) {
        int last = 0;
        int first = 0;
        while (first < nums.length) {
            if (nums[first] != val) {
                // 通过快慢指针，如果快指针遍历到的数字与目标不一致，则将慢指针指向的数字进行交换，并让慢指针加1
                nums[last] = nums[first];
                last++;
            }
            first++;
        }

        return last;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }
}
