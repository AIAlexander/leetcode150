package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class PalindromePartitioningNo131 {

    List<List<String>> result = new ArrayList<>();

    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    /**
     * 切割回文字串的重点在于index
     *      index为字串切割的切割线
     * @param s
     * @param index
     */
    public void backtracking(String s, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (!isPalindrome(s, index, i)) {
                continue;
            }
            path.add(s.substring(index, i + 1));
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    /**
     * 判断切割的字串是否为回文串
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningNo131 p  = new PalindromePartitioningNo131();
        List<List<String>> aab = p.partition("aab");
        for (int i = 0; i < aab.size(); i++) {
            System.out.println(aab.get(i));
        }
    }
}
