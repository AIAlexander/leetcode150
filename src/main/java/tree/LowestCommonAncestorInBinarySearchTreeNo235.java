package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/8/5
 */
public class LowestCommonAncestorInBinarySearchTreeNo235 {

    /**
     * 根据二叉搜索树的特性找公共祖先
     *      如果中间值大于p和q，那么公共祖先一定在左子树
     *      如果中间值小于p和q，那么公共祖先一定在右子树
     *      如果中间大于p，小于q，或者反过来，那么公共祖先就是当前中间节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = null;
        TreeNode right = null;
        if (root.val > p.val && root.val > q.val) {
            left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(7);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(8);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        LowestCommonAncestorInBinarySearchTreeNo235 l = new LowestCommonAncestorInBinarySearchTreeNo235();

        TreeNode treeNode = l.lowestCommonAncestor(r1, r5, r6);
        System.out.println(treeNode.val);
    }





}
