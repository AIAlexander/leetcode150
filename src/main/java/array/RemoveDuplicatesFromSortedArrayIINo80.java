package array;

/**
 * @author wsh
 * @date 2023/12/28
 */
public class RemoveDuplicatesFromSortedArrayIINo80 {

    /**
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int first = 2;
        int last = 2;
        if (nums.length <= 2) {
            return nums.length;
        }
        while (first < nums.length) {
            if (nums[first] != nums[last - 2]) {
                nums[last] = nums[first];
                last++;
            }
            first++;
        }

        return last;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
