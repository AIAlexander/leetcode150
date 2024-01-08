package array;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class TrappingRainWater1No42 {
    /**
     * 接雨水解法2（按列）
     * 逻辑：
     *      两边的临界都接不了水，所以从 0 < i < length - 1 遍历
     *      遍历当前的高度，找到当前左边最高的墙（maxLeft）以及右边最高的墙（maxRight），找到相对最矮的墙（min = Min(maxLeft, maxRight)），
     *      如果当前的墙(height[i])小于相对最矮的墙（min），那么该墙上能接雨水，接的量 = (min - height[i])
     * 时间复杂度：O(n^2)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for(int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = 0;
            for(int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 取两边稍矮的墙
            int min = Math.min(maxLeft, maxRight);
            if (height[i] < min) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1,0};
        System.out.println(trap(height));
    }
}
