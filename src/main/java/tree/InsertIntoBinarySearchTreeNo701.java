package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/8/5
 */
public class InsertIntoBinarySearchTreeNo701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }


        return root;
    }


    public static void main(String[] args) {

        InsertIntoBinarySearchTreeNo701 i = new InsertIntoBinarySearchTreeNo701();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(14);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(77);
        TreeNode t5 = new TreeNode(96);


        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t4.right = t5;

        TreeNode treeNode = i.insertIntoBST(t1, 4);

        System.out.println(treeNode);
    }
}
