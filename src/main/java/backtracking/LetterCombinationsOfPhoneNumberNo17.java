package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class LetterCombinationsOfPhoneNumberNo17 {
    List<String> letterGroup = new ArrayList<>();

    List<String> result = new ArrayList<>();

    StringBuilder path = new StringBuilder();


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        // 根据数字找到对应的字母集合
        for (int i = 0; i < digits.length(); i++) {
            letterGroup.add(numMap(digits.charAt(i)));
        }
        backtracking(0);
        return result;
    }

    public void backtracking(int groupIndex) {
        // 终止条件：结果集中的元素个数应与digits的数量相同
        if (path.length() == letterGroup.size()) {
            result.add(new String(path));
            return;
        }

        /**
         * 递归，先从第一个字母集中找一个元素，下一次是从第二个字母中找元素，依次类推
         * 因此groupIndex表示从第几个集合中找字母元素
         */
        for (int i = 0; i < letterGroup.get(groupIndex).length(); i++) {
            path.append(letterGroup.get(groupIndex).charAt(i));
            backtracking(groupIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public String numMap(char digit) {

        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return " ";
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumberNo17 l  = new LetterCombinationsOfPhoneNumberNo17();
        List<String> strings = l.letterCombinations("");

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }


}
