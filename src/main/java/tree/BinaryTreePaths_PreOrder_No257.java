package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/7/18
 */
public class BinaryTreePaths_PreOrder_No257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        binaryTreePaths(root, new StringBuilder(), res);
        return res;
    }

    /**
     * 使用前序序遍历：中 左 右
     * 思路：使用中间节点来判断自己是否为叶子条件，是叶子条件就将结果汇总，不是叶子，就将自己的节点加到路径中，并往下继续遍历
     * 注意：使用中序遍历时需要回溯，该方法使用new StringBuilder的方式，不改变原来的String，从而迭代方法结束后是不会改变原来的path值，起到了回溯效果
     * @param node
     * @param path
     * @param res
     */
    public void binaryTreePaths(TreeNode node, StringBuilder path, List<String> res) {
        // 终止条件：遍历到了叶子节点，将当前的节点值记录到path，并将整个path汇总到结果中
        if (node.left == null && node.right == null) {
            path.append(node.val);
            res.add(path.toString());
            return;
        }

        // 中：走到这里，说明当前节点不是叶子节点。那么将自己的值以及箭头符号添加到path中
        path.append(node.val).append("->");
        if (node.left != null) {
            // 左：遍历左子树，使用new StringBuilder方法可以起到回溯作用
            binaryTreePaths(node.left, new StringBuilder(path), res);
        }

        if (node.right != null) {
            // 右：遍历右子树，使用new StringBuilder方法可以起到回溯作用
            binaryTreePaths(node.right, new StringBuilder(path), res);
        }
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
        t4.left = t5;
        t3.left = t6;

        BinaryTreePaths_PreOrder_No257 b = new BinaryTreePaths_PreOrder_No257();
        List<String> strings = b.binaryTreePaths(t1);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

}
