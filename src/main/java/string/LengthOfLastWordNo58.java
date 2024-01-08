package string;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class LengthOfLastWordNo58 {

    public static int lengthOfLastWord(String s) {
        char[] words = s.toCharArray();
        int count = 0;
        boolean start = false;
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] != ' ') {
                start = true;
            }
            if (start) {
                if (words[i] == ' ') {
                    return count;
                }

                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
