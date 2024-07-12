package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class IsSymmetricNo101 {

    /**
     * 使用递归
     *      使用后序遍历：左 右 中
     *      与判断是否为相同的两棵树（No100）逻辑相同，前者比较相同位置上的节点是否相同，此题比较相反位置的节点是否相同
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        // 终止条件，判断两个节点是否相同
        if (l == null && r != null) {
            return false;
        }
        if (l != null && r == null) {
            return false;
        }
        if (l == null && r == null) {
            return true;
        }
        if (l.val != r.val) {
            return false;
        }
        // 如果l、r都是节点，且数值相同，继续往下遍历

        // 左：比较外侧，第一棵树的左节点 vs 第二课树的右节点
        boolean lTree = isSymmetric(l.left, r.right);
        // 右：比较内侧，第一棵树的右节点 vs 第二课树的左节点
        boolean rTree = isSymmetric(l.right, r.left);
        // 中：中间部分处理逻辑，比较左、右两边的结果，判断当前两棵树是否相互对称
        return lTree && rTree;
    }

}
