package hashmap;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class GroupAnagramsNo49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> orDefault = map.getOrDefault(new String(chars), new ArrayList<>());
            orDefault.add(str);
            map.put(new String(chars), orDefault);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(1);
    }

}
