package string;

/**
 * @author wsh
 * @date 2024/1/19
 */
public class RepeatedSubstringPatternNo459 {


    /**
     * 使用KMP算法，找到字符串的最长相同前缀的长度，通过长度 % (长度 - 前缀长度)  是否等于0判断
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {

        int[] next = new int[s.length()];

        getNext(next, s);

        int length = next[s.length() - 1];


        return length != 0 && s.length() % (s.length() - length) == 0;
    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;

        for (int i = 1; i < s.length(); i++) {

            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }

            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }

            next[i] = j;
        }
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abac"));
    }
}
