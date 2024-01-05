package array;

/**
 * @author wsh
 * @date 2024/1/5
 */
public class CandyNo135 {

    public static int candy(int[] ratings) {
        int[] l = new int[ratings.length];
        int[] r = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 1;
            }
        }

        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += Math.max(l[i], r[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,3,5,4,2,3,2};
        System.out.println(candy(ratings));
    }
}
