package dynamic;

/**
 * @author wsh
 * @date 2024/8/13
 */
public class UniqueBinarySearchTreesNo96 {

    /**
     * 给定一个数字，计算由1-n个节点能够组成多少棵二叉搜索树
     * dp数组以及含义：dp[i]表示i个节点能够组成多少棵二叉搜索树
     * dp数组初始化：dp[0] = 1, dp[1] = 1
     * 递推公式： 如果root是i的话，那么比i小的节点会排列在左子树，比i大的节点会排列在右子树。那么root是i的话的总共方法 = 左侧排列方法 * 右侧排列方法
     *          其次左侧排列方法和右侧方法都是二叉树所以他们的排列方法应该就是 dp[左节点] 和 dp[右节点]
     *          那么遍历所有root情况，得到root从1-i的所有排列方法，将他们累加都是最终结果
     * 当n=3时，分别可以使用 1，2，3来做树的根节点
     *          当根为1时，那么其他两个节点都在右边，左侧排列的方法是dp[0]，右侧为dp[2]，因此总共的排列方法为：dp[0] * dp[2]
     *          当根为2时，那么左子树一个节点，右子树一个节点，都为dp[1]，总共排列方法：dp[1] * dp[1]
     *          当根为3时，那么其他两个节点都在左边，左侧排列方式为dp[2]，右侧为dp[0]，总共排列方法：dp[2] * dp[0]
     *          所以n=3时，所有的排列 = dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
     * 因此根据推断方法：当n=i时，如果root是j时（j > 0 && j <= i）
     *          dp[i] += dp[j - 1] * dp[i - j] (0 < j <= i)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 计算root为1-i的所有排列情况，并进行累加得出dp[i]
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        UniqueBinarySearchTreesNo96 u = new UniqueBinarySearchTreesNo96();
        System.out.println(u.numTrees(3));
    }
}
