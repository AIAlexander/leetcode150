package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wsh
 * @date 2024/1/17
 */

public class LongestSubstringWithoutRepeatingCharactersNo3 {

    public static int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> resMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (resMap.containsKey(s.charAt(right))) {
                left = Math.max(left, resMap.get(s.charAt(right)) + 1);
            }
            resMap.put(s.charAt(right), right);
            res = Math.max(right - left + 1, res);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
//
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
//
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
