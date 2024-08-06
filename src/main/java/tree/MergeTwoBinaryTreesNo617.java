package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/23
 */
public class MergeTwoBinaryTreesNo617 {


    /**
     * 构造二叉树都使用前序遍历，即先处理中间节点，在处理左子树和右子树
     * 思路：
     *      处理中间节点：
     *          如果root1和root2都为空，即没有叶子节点，因此返回null
     *          如果root1为空，root2不为空，则返回root2
     *          如果root1不为空，root2为空，则返回root1
     *          如果两者都不为空，则将两个节点的值相加，并new一个新的root节点，然后新root的左子树、右子树迭代进行构建
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 终止条件：两个root均为null，则返回null
        if (root1 == null && root2 == null) {
            return null;
        }
        // 中：处理中间节点逻辑
        // root1为空，返回root2
        if (root1 == null) {
            return root2;
        }
        // root2为空，返回root1
        if (root2 == null) {
            return root1;
        }
        // 两棵树都不为空，则让两棵树的节点相加，并new出一个新的节点
        TreeNode root = new TreeNode(root1.val + root2.val);
        // 左：遍历左边，构建左子树
        root.left = mergeTrees(root1.left, root2.left);
        // 右：遍历右边，构建右子树
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(7);
        TreeNode r6 = new TreeNode(8);

        r1.left = r2;
        r1.right = r3;
        r2.right = r4;
        r3.right = r5;
        r5.right = r6;


        MergeTwoBinaryTreesNo617 m = new MergeTwoBinaryTreesNo617();
        TreeNode treeNode = m.mergeTrees(t1, r1);

        System.out.println(treeNode);
    }
}
