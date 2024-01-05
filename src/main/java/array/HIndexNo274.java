package array;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/1/5
 */
public class HIndexNo274 {

    public static int hIndex(int[] citations) {
        int h = 0;
        int index = citations.length - 1;
        Arrays.sort(citations);
        while (index >= 0 && citations[index] > h) {
            h++;
            index--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] c = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex(c));
    }
}
