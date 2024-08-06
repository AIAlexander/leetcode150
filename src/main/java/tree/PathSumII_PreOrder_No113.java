package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/7/18
 */
public class PathSumII_PreOrder_No113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSum(root, new ArrayList<>(), res, targetSum);
        return res;
    }


    /**
     * 思路与No.112一样，只不过记录了路径
     * @param cur
     * @param path
     * @param res
     * @param targetSum
     */
    public void pathSum(TreeNode cur, List<Integer> path, List<List<Integer>> res, int targetSum) {

        if (cur.left == null && cur.right == null) {
            if (cur.val == targetSum) {
                path.add(cur.val);
                res.add(path);
            }
            return;
        }

        path.add(cur.val);
        targetSum -= cur.val;
        if (cur.left != null) {
            pathSum(cur.left, new ArrayList<>(path), res, targetSum);
        }

        if (cur.right != null) {
            pathSum(cur.right, new ArrayList<>(path), res, targetSum);
        }
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
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t4.left = t7;
        t4.right = t8;

        t3.left = t5;
        t3.right = t6;
        t6.left = t9;
        t6.right = t10;

        PathSumII_PreOrder_No113 p = new PathSumII_PreOrder_No113();
        List<List<Integer>> lists = p.pathSum(t1, 22);



    }
}
