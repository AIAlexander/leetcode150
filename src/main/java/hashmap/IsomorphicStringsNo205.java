package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class IsomorphicStringsNo205 {


    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> lMap = new HashMap<>();
        Map<Character, Character> rMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {

            if((lMap.containsKey(s.charAt(i)) && lMap.get(s.charAt(i)) != t.charAt(i))
                    || (rMap.containsKey(t.charAt(i)) && rMap.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            }
            lMap.put(s.charAt(i), t.charAt(i));
            rMap.put(t.charAt(i), s.charAt(i));

        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbab"));
    }
}
