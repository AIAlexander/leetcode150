package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/14
 */
public class WordBreakNo139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i);
                if (wordDict.contains(sub) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreakNo139 w = new WordBreakNo139();
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("pen");
        System.out.println(w.wordBreak("applepenapple", words));
    }
}
