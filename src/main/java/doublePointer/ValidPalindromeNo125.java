package doublePointer;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class ValidPalindromeNo125 {

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // 排除非数字字母的char
            if (!((chars[left] >= 48 && chars[left] <= 57) || (chars[left] >= 97 && chars[left] <= 122))) {
                left++;
                continue;
            }
            // 排除非数字字母的char
            if (!((chars[right] >= 48 && chars[right] <= 57) || (chars[right] >= 97 && chars[right] <= 122))) {
                right--;
                continue;
            }

            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
