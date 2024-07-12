package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class MaxDepth_PostOrder_No104 {


    /**
     * 递归解题：
     *     使用后序遍历，左 -》右 -》中
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 递归第一步：确定终止条件
        if (root == null) {
            return 0;
        }
        // 递归第二步：确认逻辑
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        // 通过中间节点获取到左、右子树的最大深度，然后再加上自己即为最大深度
        return Math.max(lDepth, rDepth) + 1;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);


        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;


        MaxDepth_PostOrder_No104 d = new MaxDepth_PostOrder_No104();
        System.out.println(d.maxDepth(t1));
    }
}
