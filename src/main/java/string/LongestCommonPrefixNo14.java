package string;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class LongestCommonPrefixNo14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < length && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"disant", "disand", "disanp"};
        System.out.println(longestCommonPrefix(strs));
    }


}
