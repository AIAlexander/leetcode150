package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/23
 */
public class ValidateBinarySearchTreeNo98 {

    long maxValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        // 左：左边遍历
        boolean validBST = isValidBST(root.left);
        // 中：处理结果
        if (root.val > maxValue) {
            maxValue = root.val;
        } else  {
            return false;
        }
        // 右：右边遍历
        boolean validBST1 = isValidBST(root.right);

        return validBST && validBST1;
    }


    public static void main(String[] args) {


        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(6);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(7);

        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;

        ValidateBinarySearchTreeNo98 v = new ValidateBinarySearchTreeNo98();
        System.out.println(v.isValidBST(r1));

    }
}
