package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class ThreeSumNo15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        Arrays.sort(nums);

        while (i < nums.length && nums[i] <= 0) {
            int left = i + 1;
            int right = nums.length - 1;

            int result = nums[i];

            while (left < right) {
                List<Integer> sub = new ArrayList<>();
                int leftNum = nums[left];
                int rightNum = nums[right];
                sub.add(result);

                int sum = result + leftNum + rightNum;

                if (sum == 0) {
                    sub.add(leftNum);
                    sub.add(rightNum);
                    res.add(sub);
                    while (left < right && leftNum == nums[left + 1]) {
                        left++;
                    }
                    while (left > right && rightNum == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum < 0) {
                    left++;

                } else {
                    right--;

                }

            }

            while (i < nums.length && nums[i] == result) {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);
    }
}
