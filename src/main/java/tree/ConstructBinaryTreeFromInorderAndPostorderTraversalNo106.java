package tree;

import entity.TreeNode;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/7/23
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalNo106 {


    /**
     * inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 思路：
     *      1。 根据后序遍历，我们可以知道数组的最后一个是这颗子树的根节点，比如为3
     *      2。 然后通过节点3，去中序遍历找到3所在的位置，那么该位置的左侧即为这棵3为根的左子树，该位置的右侧为右子树，即
     *           [9] 为左子树的中序遍历数组，[15, 20, 7] 为右子树的中序遍历数组
     *      3。 然后通过左子树中序遍历数组的大小截取后序遍历的数组
     *          [9] 左子树的长度为1，那么在后序遍历中前面长度为1的子树组为左子树的后序遍历，其余部分除掉最后一个树的数组为右子树的后序遍历数组
     *          即：[9] 为左子树的后序遍历数组，[15, 7, 20]为右子树的后序遍历数组
     *      4。 循环上述过程，每次执行完返回这棵树的root节点
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 终止条件：如果中序遍历数组为空，则表示当前节点没有子树，因此返回null
        if (inorder.length <= 0) {
            return null;
        }
        // 终止条件：如果后序序遍历数组为空，则表示当前节点没有子树，因此返回null
        if (postorder.length <= 0) {
            return null;
        }
        // 将后序遍历数组中的最后一个元素作为这棵树的root节点
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        // 在中序遍历数组中找到root节点的位置，方便在中序遍历数组中切分左、右子树
        while (inorder[index] != rootVal) {
            index++;
        }
        // index为当前树的root节点在中序遍历数组的位置
        // 因此[0, index)部分为这棵树的左子树的中序遍历数组
        int[] leftInOrderArr = Arrays.copyOfRange(inorder, 0, index);
        // 而[index+1, 数组length)部分为这棵树的右子树的中序遍历数组
        int[] rightInOrderArr = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // 找到了左、右子树的中序数组之后，可以根据左子树的中序数组长度在后序遍历数组中切分左、右子树的后序遍历数组
        // 因此在后序数组中，[0, 左子树中序遍历数组length) 为左子树的后序遍历数组
        int[] leftPostOrderArr = Arrays.copyOfRange(postorder, 0, leftInOrderArr.length);
        // 在后序数组中，[左子树中序遍历数组length, 后序数组length - 1) 为右子树的后序遍历数组，因为最后一位是root的节点，需排除
        int[] rightPostOrderArr = Arrays.copyOfRange(postorder, leftInOrderArr.length, postorder.length - 1);

        // 将左子树的中序、后序遍历数组传入迭代中，返回值为左子树的root
        root.left = buildTree(leftInOrderArr, leftPostOrderArr);
        // 同理，返回值为右子树的root
        root.right = buildTree(rightInOrderArr, rightPostOrderArr);

        return root;

    }


    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversalNo106 c = new ConstructBinaryTreeFromInorderAndPostorderTraversalNo106();
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};

        TreeNode treeNode = c.buildTree(inOrder, postOrder);

        System.out.println(treeNode);
    }
}
