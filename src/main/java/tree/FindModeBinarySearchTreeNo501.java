package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/5
 */
public class FindModeBinarySearchTreeNo501 {

    TreeNode pre = null;
    int maxCount = 0;
    int count = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

    /**
     * 寻找二叉树搜索树的众数，利用二叉树搜索数的特点使用双指针+中序遍历方法寻找
     * 方法：遍历树的时候，不断更新数据的最大出现次数
     * 逻辑：中序遍历树，pre节点为上次遍历节点
     *      如果pre节点与当前节点的值相同，count + 1
     *      如果pre节点与当前节点的值不同，count就重制为1
     *      pre与cur比较完成之后，
     *          count如果与maxCount相同，则把当前值加入到集合
     *          count如果大于maxCount，说明找到了新的众数，因此将之前的集合清空，更新为新的众数集合
     * @param cur
     */
    public void find(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 左
        find(cur.left);
        // 中
        if (pre == null) {
            // 遍历到的第一个节点，count初始化为1
            count = 1;
        } else if (cur.val == pre.val) {
            // cur与pre相同，count++
            count++;
        } else {
            // cur与pre不相同，count重制为1，说明是新一次的数据频次统计
            count = 1;
        }
        // 指针更换
        pre = cur;
        // count值与maxCount相等，说明当前数值符合众数条件
        if (count == maxCount) {
            result.add(cur.val);
        }
        // count值大于maxCount，说明之前计算的频次不是最大频次，因此需要重制结果，并把新的众数添加到结果集
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(cur.val);
        }
        // 右
        find(cur.right);
    }

    public static void main(String[] args) {
        FindModeBinarySearchTreeNo501 f = new FindModeBinarySearchTreeNo501();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;

        int[] mode = f.findMode(t1);

        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }

    }
}
