package array;

/**
 * @author wsh
 * @date 2023/12/28
 */
public class MergeSortedArrayNo88 {

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        // 从后往前填充数据，谁大填谁
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                i--;
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                i--;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0};
        int[] nums2 = new int[]{2,3};

        merge(nums1, 0, nums2, 2);
        System.out.println("nums1");
    }
}
