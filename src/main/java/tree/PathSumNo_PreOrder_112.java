package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class PathSumNo_PreOrder_112 {

    /**
     * 使用前序遍历：中 左 右
     *      前序遍历需要进行回溯
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
       return hasPathSum(root, root.val, targetSum);
    }

    public boolean hasPathSum(TreeNode cur, int sum, int targetSum) {
        // 终止条件，遍历到叶子节点时，进行判断当前的路径是否等于目标值
        if (cur.left == null && cur.right == null) {
            // 因为题目是计算路径，路径指的是根节点到叶子节点的数值，所以一定要在叶子节点的时候判断
            if (sum == targetSum) {
                return true;
            }
            return false;
        }
        boolean l = false;
        boolean r = false;
        // 左：计算左子树的路径和
        if (cur.left != null) {
            sum += cur.left.val;
            l = hasPathSum(cur.left, sum, targetSum);
            sum -= cur.left.val;
        }
        // 右：计算右子树的路径和
        if (cur.right != null) {
            sum += cur.right.val;
            r = hasPathSum(cur.right, sum, targetSum);
            sum -= cur.right.val;
        }

        // 只要一条路径满足条件即可
        return l || r;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.right = t9;

        PathSumNo_PreOrder_112 p = new PathSumNo_PreOrder_112();
        System.out.println(p.hasPathSum(t1, 22));
    }
}
