package array;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/1/5
 *
 * 第二种解法：计数器
 */
public class HIndex2No274 {

    public static int hIndex(int[] citations) {
        int[] counter = new int[citations.length + 1];

        for(int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length) {
                counter[citations.length]++;
            } else {
                counter[citations[i]]++;
            }
        }

        int h = 0;
        int index = counter.length - 1;
        while (index > 0 ) {
            h += counter[index];
            if (h >= index) {
                return index;
            }
            index--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] c = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex(c));
    }

}
