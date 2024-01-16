package doublePointer;

/**
 * @author wsh
 * @date 2024/1/16
 */
public class ContainerWithMostWaterNo11 {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;
        int h = 0;

        while (left < right) {
            h = Math.min(height[left], height[right]);
            int l = right - left;
            area = Math.max(h * l, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area == Integer.MIN_VALUE ? 0 : area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,15,2,5,4,12,13,7};
        System.out.println(maxArea(height));
    }
}
