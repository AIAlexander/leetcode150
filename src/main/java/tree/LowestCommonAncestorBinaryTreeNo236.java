package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/8/5
 */
public class LowestCommonAncestorBinaryTreeNo236 {


    /**
     * 后序遍历寻找最近的公共祖先，使用后序遍历，把中节点放在最后汇总两棵子树的结果
     * 逻辑：
     *      中间节点判断
     *          如果左，右子树的结果都是null，说明左，右子树都没有p和q，那么就返回null
     *          如果左右子树的结果都不为null，说明左、右子树有p和q，那么当前的节点就应该是p和q的最近公共祖先
     *          如果左，右子树的结果一个为null，一个不为null，说明左、右子树其中一个含有p和q，那么当前节点不是公共祖先，还需要往上返回
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果遍历到了p和q，需要将自己的结果返回
        if (root == p || root == q) {
            return root;
        }
        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 中，判断当前节点是不是最近公共祖先
        if (left != null && right != null) {
            // 左、右不为null，说明左、右子树有p和q，那么当前节点为公共祖先
            return root;
        } else if (left != null) {
            // 左不为null，说明左子树有p或q，那么当前节点不是公共祖先，需要向上返回结果
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinaryTreeNo236 l  = new LowestCommonAncestorBinaryTreeNo236();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);

        t1.left = t2;
        t1.right = t3;
        TreeNode treeNode = l.lowestCommonAncestor(t1, t3, t2);
        System.out.println(treeNode);
    }
}
