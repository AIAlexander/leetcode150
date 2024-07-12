package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class CountCompleteTreeNodes_PostOrder_No222 {


    /**
     * 使用后序遍历 左 右 中
     *      中间节点汇总左、右两侧的节点数量
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }

        // 左：计算左侧节点数量
        int i = countNodes(root.left);
        // 右：计算右侧节点数量
        int j = countNodes(root.right);
        // 中：汇总左右两侧节点数量，并且加上当前中间节点，即加1
        return i + j + 1;
    }

    /**
     * 使用后序遍历 左 右 中
     *      考虑到是计算完全二叉树，因此可以考虑优化
     *      优化方案：
     *          如果左子树的深度等于右子树的深度，那么这颗子树的节点数量满足公式： 2^k - 1
     * @param root
     * @return
     */
    public int countNodesBetter(TreeNode root) {
        //终止条件
        if (root == null) {
            return 0;
        }

        // 判断当前左、右子树是否为完全二叉树
        TreeNode curl = root;
        TreeNode curR = root;
        int lDepth = 0;
        int rDepth = 0;
        while (curl != null) {
            // 左指针
            lDepth++;
            curl = curl.left;
        }
        while (curR != null) {
            // 右指针
            rDepth++;
            curR = curR.right;
        }
        if (lDepth == rDepth) {
            // 左侧与右侧的高度相同，说明是一颗完全二叉树，不需要继续遍历即能计算节点数量
            return (int)Math.pow(2, lDepth) - 1;
        }

        // 如果不是完成二叉树，那么就通过原始的遍历方式计算

        // 左：计算左侧节点数量
        int i = countNodes(root.left);
        // 右：计算右侧节点数量
        int j = countNodes(root.right);
        // 中：汇总左右两侧节点数量，并且加上当前中间节点，即加1
        return i + j + 1;
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
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;


        CountCompleteTreeNodes_PostOrder_No222 c = new CountCompleteTreeNodes_PostOrder_No222();
        System.out.println(c.countNodesBetter(t1));
    }
}
