package string;

/**
 * @author wsh
 * @date 2024/1/9
 */
public class FindIndexOfTheFirstOccurrenceInStringNo28 {

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int right = 0;

        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for(int i = 0; i < h.length; i++) {
            int index = i;
            int length = 0;
            while (right < n.length && index < h.length && h[index] == n[right]) {
                index++;
                right++;
                length++;
            }

            if (length == n.length) {
                return i;
            } else {
                length = 0;
                right = 0;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }
}
