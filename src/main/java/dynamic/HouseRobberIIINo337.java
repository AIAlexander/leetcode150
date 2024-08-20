package dynamic;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/8/16
 */
public class HouseRobberIIINo337 {

    /**
     * 打家劫舍3，房子是二叉树结构，同时也满足相邻节点不能偷
     * 分析：需要遍历二叉树，使用后序遍历，左右中，因为在中间节点需要抉择偷还是不偷，抉择判断依赖左、右子树的结果，因此需要先计算出左、右子树的结果
     * dp数组含义：dp数组与之前动归问题不同，本题目使用长度为2的数组来代表dp数组，即每个节点都有一个自己的dp数组
     *          其中dp数组主要是描述当前节点的状态，因此dp[0]表示当前节点不偷的最大金额，dp[1]表示偷取当前节点的最大金额
     *          比如叶子节点3，那么dp数组应该为：{0 ,3}
     * 递推公式：通过中间节点判断，中间节点的dp应该为： root的dp[0] = 左子树的Math.max(dp[0],dp[1]) + 右子树的Math.max(dp[0], dp[1])
     *                                         root的dp[1] = 左子树的dp[0] + 右子树的dp[0] + root
     * 遍历顺序：后序遍历，递归的返回值是长度为2的dp数组，答案即是dp[0],dp[1]中的最大值
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 递归函数
     */
    public int[] robSub(TreeNode cur) {
        // 终止条件
        if (cur == null) {
            // 遍历到null节点时，dp[0]，dp[1]均为0
            return new int[2];
        }
        // 左
        int[] leftRes = robSub(cur.left);
        // 右
        int[] rightRes = robSub(cur.right);
        // 中：计算当前节点偷或不偷的情况
        int[] res = new int[2];
        // 当前没偷
        res[0] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        res[1] = leftRes[0] + rightRes[0] + cur.val;
        return res;
    }

    public static void main(String[] args) {
        HouseRobberIIINo337 h = new HouseRobberIIINo337();
//        TreeNode t1 = new TreeNode(3);
//        TreeNode t2 = new TreeNode(4);
//        TreeNode t3 = new TreeNode(5);
//        TreeNode t4 = new TreeNode(1);
//        TreeNode t5 = new TreeNode(3);
//        TreeNode t6 = new TreeNode(1);
//
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.right = t6;


        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);

        t1.left = t2;
        t2.left = t3;
        t3.left = t4;

        System.out.println(h.rob(t1));
    }
}
