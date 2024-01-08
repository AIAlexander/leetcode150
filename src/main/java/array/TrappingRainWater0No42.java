package array;

/**
 * @author wsh
 * @date 2024/1/8
 */
public class TrappingRainWater0No42 {
    /**
     * 接雨水解法1（按层），遍历每一层能够接多少雨水，从第一层到最高一层
     * 时间：O(m * n)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int maxHeight = getMaxHeight(height);
        boolean isStart = false;
        int sum = 0;
        int tmp = 0;

        for(int i = 1; i <= maxHeight; i++) {
            // 从第一层遍历到最后一层，即 height[i] = 1 - maxHeight
            isStart = false;
            tmp = 0;
            for(int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    tmp++;
                }
                if (height[j] >= i) {
                    sum = sum + tmp;
                    isStart = true;
                    tmp = 0;
                }
            }
        }
        return sum;
    }

    private static int getMaxHeight(int [] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1,0};
        System.out.println(trap(height));
    }
}
