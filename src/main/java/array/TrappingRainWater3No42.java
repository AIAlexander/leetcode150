package array;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class TrappingRainWater3No42 {
    /**
     * 接雨水解法4（双指针）
     * 逻辑与解法2一样，
     * 时间复杂度：O(n)
     *
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        int left = 1;
        int right = height.length - 2;
        int maxLeft = 0;
        int maxRight = 0;

        for(int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1,0};
        System.out.println(trap(height));
    }
}
