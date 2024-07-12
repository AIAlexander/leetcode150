package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class MaxDepth_PreOrder_No104 {

//    int res = 0;

    /**
     * 使用递归方法计算：
     *      前序遍历：中 -》 左 -》 右
     *      注意：使用前序遍历需要回溯
     * @param root
     * @param depth
     * @param res
     * @return
     */
    public int maxDepth(TreeNode root, int depth, int res) {
        // 中：记录当前节点的最大深度
        res = Math.max(depth, res);
        // 递归第一步：确定终止条件
        if (root.left == null && root.right == null) {
            return res;
        }
        // 递归第二步：确认逻辑
        if (root.left != null) {
            // 计算左侧子树的最大深度
            depth++;
            res = maxDepth(root.left, depth, res);
            // 到这部分已经重新回到了中间节点，左子树遍历完成，需要将深度恢复成中间节点的深度，即dept要减1
            depth--;
        }

        if (root.right != null) {
            depth++;
            res = maxDepth(root.right, depth, res);
            depth--;
        }

        return res;

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1, 0);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);
        TreeNode t6 = new TreeNode(11);


        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t5.left = t6;

        MaxDepth_PreOrder_No104 p = new MaxDepth_PreOrder_No104();
        System.out.println(p.maxDepth(t1));
    }
}
