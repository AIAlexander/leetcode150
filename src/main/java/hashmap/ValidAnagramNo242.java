package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class ValidAnagramNo242 {

    public static boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }
}
