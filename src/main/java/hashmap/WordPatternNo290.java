package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class WordPatternNo290 {


    public static boolean wordPattern(String pattern, String s) {

        if (pattern == null || s == null) {
            return false;
        }
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) {
            return false;
        }

        Map<String, Character> w2p = new HashMap<>();
        Map<Character, String> p2w = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            if ((w2p.containsKey(s1[i]) && w2p.get(s1[i]) != pattern.charAt(i)) ||
                    (p2w.containsKey(pattern.charAt(i)) && p2w.get(pattern.charAt(i)).compareTo(s1[i]) != 0)) {
                return false;
            }

            w2p.put(s1[i], pattern.charAt(i));
            p2w.put(pattern.charAt(i), s1[i]);
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
