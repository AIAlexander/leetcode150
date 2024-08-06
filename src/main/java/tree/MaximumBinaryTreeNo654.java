package tree;

import entity.TreeNode;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/7/23
 */
public class MaximumBinaryTreeNo654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 终止条件：数组为空表示当前树没有子树，返回null
        if (nums.length == 0) {
            return null;
        }

        // 找到当前数组中的最大值作为这棵树的root节点，index为最大值的索引，max为最大值
        int index = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        // 通过根节点去切分数组，左边的即为左子树，右边的即为右子树
        int[] left = Arrays.copyOfRange(nums, 0, index);
        int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);
        // 迭代遍历找到左子树和右子树
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }


    public static void main(String[] args) {
        MaximumBinaryTreeNo654 m = new MaximumBinaryTreeNo654();
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = m.constructMaximumBinaryTree(nums);

        System.out.println(treeNode);
    }

}
