package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class CombinationsNo77 {

    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack<>();

    /**
     * 回溯算法解决组合问题
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }


    public void backtracking(int n, int k, int index) {
        // 终止条件，找到了组合为k的集合就停止
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        /**
         * 递归逻辑（简单：i根据index从n个数据递归去找）
         * 剪枝优化（由于一些特殊情况下，i其实不需要再向后查找了，因为所剩的元素已经无法构建k个数的组合）
         *      比如：n = 4，k = 4时，当path中取了2之后，剩下的元素只有3，4，最大组合也就是2，3，4，k=3满足不了k=4的结果集，因此该部分应该剪枝
         *      因此需要根据n，k计算出index的最小的搜索范围
         *      n - (k - path.size) + 1
         *          k - path.size 表示还需要多少元素组合成k大小集合，那么n中如果剩下 k - path.size - 1 个数就不能组成k个大小集合
         */
        for (int i = index; i <= (n - (k - path.size()) + 1); i++) {
            // 添加元素
            path.add(i);
            // 递归寻找结果集
            backtracking(n, k, i + 1);
            // 回溯，移除元素
            path.pop();
        }
    }


    public static void main(String[] args) {
        CombinationsNo77 c = new CombinationsNo77();
        List<List<Integer>> combine = c.combine(4, 2);

        for (int i = 0; i < combine.size(); i++) {
            System.out.println(combine.get(i));
        }
    }
}
