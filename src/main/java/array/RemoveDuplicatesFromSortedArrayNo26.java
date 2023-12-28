package array;

/**
 * @author wsh
 * @date 2023/12/28
 */
public class RemoveDuplicatesFromSortedArrayNo26 {

    /**
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        int first = 0;
        int last = 0;

        while(first < nums.length) {
            // 使用快慢指针，快指针对应的数与慢指针对应的数不一致，则慢指针进行赋值，并慢指针加1
            if (nums[last] != nums[first]) {
                last++;
                nums[last] = nums[first];
            }
            first++;
        }

        return last + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
