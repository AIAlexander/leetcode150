package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class LongestConsecutiveSequenceNo128 {


    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        int maxLen = 1;

        for (Integer num : map.keySet()) {
            if (!map.containsKey(num - 1)) {

                int curNum = num;
                int curLength = 1;

                while (map.containsKey(curNum + 1)) {
                    curLength++;
                    curNum++;
                }

                maxLen = Math.max(curLength, maxLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{100,200,1,4,3,2,300,201,202,203,204,205};
        System.out.println(longestConsecutive(nums));
    }
}
