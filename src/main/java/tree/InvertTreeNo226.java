package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class InvertTreeNo226 {


    /**
     * 使用递归：
     *      使用后序遍历： 左 右 中
     *      只有使用后序遍历，先翻转左子树，然后翻转右子树，最终在中间节点处左、右再进行翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        // 左：翻转左子树
        invertTree(root.left);
        // 右：翻转右子树
        invertTree(root.right);
        // 中：中间部分翻转节点的左子树和右子树
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;

        return root;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(18);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        InvertTreeNo226 i = new InvertTreeNo226();
        i.invertTree(t1);

        System.out.println(t1);
    }
}
