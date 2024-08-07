package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class CombinationSumIINo40 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 此题目与前几道组合题目的区别在于集合中存在重复的元素，如果按照之前的方法写，结果中会出现相同的结果集
     *      如：[1,2,1] target = 3，会输出结果 [1,2] 和 [2,1]
     *
     * 去重的逻辑：
     *      将数组先排序，变成[1,1,2]
     *      此时第一次选取index=0，数值为1的逻辑与第二次index=1，数值为2的逻辑相同，因此第二次选取就应该被跳过
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // 生成used数组，用来去重
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, used);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int index, boolean[] used) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            /**
             * 通过used函数去重
             * 在题目中是可以选取值相同的元素的，即[1,1,2]，可以选取子集[1,1]
             * 所以去重的重点在于：纵向递归时，能够选取相同元素；而横向不能选取相同的元素
             * 因此使用used数组标记位来区分当前选取是横向还是纵向选取
             * 比如：[1,1,2]
             *      当纵向选取时，选到重复元素value=1，index=1的时候，此时used为[true, false, false]，
             *          因此前一个index=0的时候used是true，所以此时能被选择，说明当前操作是[1,1]的纵向选择
             *      当横向选取时，选到重复元素value=1，index=1的时候，此时used为[false, false, false]，因为之前index=0，value=1的情况已经递归结束
             *          这个时候used为false，说明当前操作是[1]的横向选择，此时就不应该再被选择，因为与上一次的选取重复了
             */
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, sum, i + 1, used);
            sum -= candidates[i];
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSumIINo40 c = new CombinationSumIINo40();
        int[] cand = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = c.combinationSum2(cand, 8);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}


