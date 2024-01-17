package slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/17
 */
public class MinimumWindowSubstringNo76 {

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int needCount = t.length();

        int left = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            if (needMap.getOrDefault(s.charAt(right), 0) > 0) {
                needCount--;
            }

            if (needMap.containsKey(s.charAt(right))) {
                needMap.put(s.charAt(right), needMap.get(s.charAt(right)) - 1);
            }

            if (needCount == 0) {
                // 移动left
                while (!needMap.containsKey(s.charAt(left)) || needMap.get(s.charAt(left)) < 0) {
                    if (needMap.containsKey(s.charAt(left))) {
                        needMap.put(s.charAt(left), needMap.get(s.charAt(left)) + 1);
                    }
                    left++;
                }

                // 说明当前的窗口的字符串是字串
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                needMap.put(s.charAt(left), needMap.get(s.charAt(left)) + 1);
                left++;
                needCount++;
            }
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "BAC"));
    }
}
