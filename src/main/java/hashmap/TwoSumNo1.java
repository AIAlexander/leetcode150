package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class TwoSumNo1 {

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        if (nums == null || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                res[0] = i;
                res[1] = map.get(sub);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};

        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
