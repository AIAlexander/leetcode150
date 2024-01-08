package array;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class TrappingRainWater2No42 {
    /**
     * 接雨水解法3（动态规划）
     * 逻辑与解法2一样，只不过这次是将每个点的左右最高高度的墙结果维护在数组中，用空间换时间
     *      maxLeft[i] 表示i点左边最高的墙，maxRight[i]表示i点右边最高的墙
     * 时间复杂度：O(n)
     *
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }
        for(int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
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
