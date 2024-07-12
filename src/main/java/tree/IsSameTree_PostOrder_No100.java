package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/12
 */
public class IsSameTree_PostOrder_No100 {

    /**
     * 使用递归方法：
     *      后序遍历： 左 -》 右 -》 中
     *      先处理左、右子树是否相同，然后在中间节点处判断两边的树是否相等
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 确定终止条件
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }

        // 左：比较两边的左子树是否相同
        boolean l = isSameTree(p.left, q.left);
        // 右：比较两边的右子树是否相同
        boolean r = isSameTree(p.right, q.right);

        // 中：中间节点汇总结果， 判断当前这棵树是否左右相同
        return l && r;
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
//        t3.right = t5;
//        t5.left = t6;

        TreeNode tt1 = new TreeNode(1);
        TreeNode tt2 = new TreeNode(3);
        TreeNode tt3 = new TreeNode(15);
        TreeNode tt4 = new TreeNode(9);
        TreeNode tt5 = new TreeNode(20);
        TreeNode tt6 = new TreeNode(11);


        tt1.left = tt2;
        tt1.right = tt3;
        tt3.left = tt4;
        tt3.right = tt5;
        tt5.left = tt6;

        IsSameTree_PostOrder_No100 i = new IsSameTree_PostOrder_No100();
        System.out.println(i.isSameTree(t1, tt1));
    }
}
