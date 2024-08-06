package tree;

import entity.TreeNode;

/**
 * @author wsh
 * @date 2024/7/23
 */
public class SearchInBinarySearchTreeNo700 {


    /**
     * 使用前序遍历查找节点
     *      中间节点的逻辑：
     *          如果中间节点的值与val相同，则直接返回节点
     *          利用二叉搜索树的特点：如果val比节点值小，就往左子树找，反之往右子树找
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // 终止条件：遍历到空时，即无法找到目标值，返回null
        if (root == null) {
            return null;
        }
        // 中：如果val与root相同直接返回结果
        if (root.val == val) {
            return root;
        }
        TreeNode lRes = null;
        TreeNode rRes = null;
        // 如果val小于root节点，则往左子树查找
        if (root.val > val) {
            lRes = searchBST(root.left, val);
        }

        // 如果val大于root节点，则往右子树查找
        if (root.val < val) {
            rRes = searchBST(root.right, val);
        }

        // 返回结果左右两边不为null的结果
        return lRes != null ? lRes : rRes;
    }

    public static void main(String[] args) {
        SearchInBinarySearchTreeNo700 s = new SearchInBinarySearchTreeNo700();
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

        TreeNode treeNode = s.searchBST(r1, 50);
        System.out.println(treeNode);
    }
}
