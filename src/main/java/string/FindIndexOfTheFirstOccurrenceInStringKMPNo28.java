package string;

/**
 * @author wsh
 * @date 2024/1/9
 *
 * 使用KMP算法
 * 获取模式串的最长前后缀长度组成前缀表next数组，匹配时如果发生冲突，根据next数组进行跳跃匹配
 */
public class FindIndexOfTheFirstOccurrenceInStringKMPNo28 {

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int[] next = new int[needle.length()];
        // 获取前缀表
        getNext(next, needle);

        int left = 0;
        for (int right = 0; right < haystack.length(); right++) {

            while (left != 0 && needle.charAt(left) != haystack.charAt(right)) {
                left = next[left - 1];
            }


            if (needle.charAt(left) == haystack.charAt(right)) {
                left++;
                if (left == needle.length()) {
                    return right - needle.length() + 1;
                }
            }
        }

        return -1;
    }

    private static void getNext(int[] next, String needle) {
        // j表示前缀，以及当前字符串中最长前后缀的长度
        int j = 0;
        // i表示后缀
        int i = 1;
        // 初始化，前缀表第一个位置为0，表示如果第一位发生不匹配，则字串移动一位
        next[0] = 0;

        for (; i < needle.length(); i++) {
            // 比较i，j上的字母是否相同，如果不相同，j需要往前移动，移动到next[j-1]的位置，直到移动到0位置，或者i，j上的字母相同

            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                // 如果相等，j向前一个位置
                j++;
            }

            // 赋值
            next[i] = j;
        }
    }


    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issapp"));
    }
}
