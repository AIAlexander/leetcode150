package array;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class RomanToIntegerNo13 {

    public static int romanToInt(String s) {
        int result = 0;
        char[] romanNum = s.toCharArray();
        for(int i = 0; i < romanNum.length; i++) {
            int num = rule(romanNum[i]);
            if (i < romanNum.length - 1 && num < rule(romanNum[i + 1])) {
                result += (rule(romanNum[i + 1]) - num);
                i++;
            } else {
                result += num;
            }
        }
        return result;
    }

    public static int rule(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
