package doublePointer;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class IsSubsequenceNo392 {

    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()) {

            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }

            if (left == s.length()) {
                return true;
            }

            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
