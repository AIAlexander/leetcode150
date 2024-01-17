package slideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/17
 */
public class SubstringWithConcatenationAllWordsNo30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        // 统计字串的出现频次
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 字串的长度
        int subSize = words[0].length();
        // 字串的个数
        int num = words.length;
        // 字串的总长度
        int size = subSize * num;

        /**
         * 遍历的思路，是根据词的长度遍历，比如词的长度为3，那就窗口每一次的移动都是3，因此只需要遍历索引0，1，2即可，后面的遍历都是重复的
         */
        for (int i = 0; i < subSize; i++) {

            // 统计left，right所在窗口的每个词的词频
            Map<String, Integer> windowMap = new HashMap<>();
            int left = i;
            int right = i;
            int count = 0;

            // 遍历s串中的所有单词
            while (right + subSize <= s.length()) {
                // right滑动，记录本次滑动的单词
                String word = s.substring(right, right + subSize);
                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                right += subSize;
                count++;

                /**
                 * left滑动的逻辑：
                 *      1。 right本次滑动的词不在字串中，说明本次窗口已不符合要求，因此left会移动right的位置
                 *      2。 right本次滑动的词是字串中，但是窗口中该词的数量超过了字串中的数量，需要left移动到right - 3 的位置
                 * 通过循环实现可以兼容上述两种情况
                 */
                while (windowMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                    String leftWord = s.substring(left, left + subSize);
                    // left移动时，需要将词从滑动窗口中踢出
                    windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                    count--;
                    left += subSize;
                }

                // 如果数量与字串的数量相同，则说明是符合条件的串
                if (count == num) {
                    result.add(left);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"foo", "bar"};
        System.out.println(findSubstring("barfoothefoobarman", words));
    }
}
