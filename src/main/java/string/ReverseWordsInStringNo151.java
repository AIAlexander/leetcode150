package string;

/**
 * @author wsh
 * @date 2024/1/9
 */
public class ReverseWordsInStringNo151 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] s1 = s.split(" ");
        int right = s1.length- 1;

        while (right >= 0) {
            sb.append(s1[right]);
            if (s1[right].length() > 0) {
                sb.append(" ");
            }
            right--;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello    world"));
    }
}
