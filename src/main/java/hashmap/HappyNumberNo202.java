package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2024/1/22
 */
public class HappyNumberNo202 {


    public static boolean isHappy(int n) {
        int sum = n;

        Map<Integer, Integer> map = new HashMap<>();

        while (sum != 1 && !map.containsKey(sum)) {
            map.put(sum, 1);
            int subSum = 0;
            while (sum > 0) {
                int d = sum % 10;
                sum = sum / 10;
                subSum += d * d;
            }
            sum = subSum;

        }
        return sum == 1;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(116));
    }
}
