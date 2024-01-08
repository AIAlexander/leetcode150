package string;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class IntegerToRomanNo12 {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < nums.length; i++) {
           while (num - nums[i] >= 0) {
               sb.append(symbol[i]);
               num -= nums[i];
           }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
