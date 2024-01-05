package array;

/**
 * @author wsh
 * @date 2024/1/5
 */
public class ProductArrayExceptSelfNo238 {


    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // l表示当前数左侧的乘积
        int[] l = new int[nums.length];
        // r表示当前数右侧的乘积
        int[] r = new int[nums.length];
        // 答案即为 l(左侧的乘积) * r(右侧的乘积)

        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = l[i] * r[i];
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(res);

    }
}
