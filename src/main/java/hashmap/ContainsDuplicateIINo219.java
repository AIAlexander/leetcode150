package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class ContainsDuplicateIINo219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
