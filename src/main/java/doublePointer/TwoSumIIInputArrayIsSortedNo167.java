package doublePointer;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class TwoSumIIInputArrayIsSortedNo167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        int[] arr = new int[2];

        while (left < right) {
            int res = numbers[left] + numbers[right];
            if (res == target) {
                arr[0] = left + 1;
                arr[1] = right + 1;
                return arr;
            } else if (res < target) {
                left++;
            } else {
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] ints = twoSum(numbers, 9);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
