package backtracking;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 *
 * No39 组合问题（剪枝优化）
 */
public class CombinationSumNo39_advanced {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    /**
     * 与组合问题的区别在于元素可重复进行选择
     *      之前问题只能选一次，因此在下一次递归时，index应该是上一次index + 1
     *      而这个问题元素能重复选择，所以下一次递归时，index就是上一次的index
     * @param candidates
     * @param target
     * @param sum
     * @param index
     */
    public void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum = sum + candidates[i];
            // 传入的index为i，表示下一次选取的元素可重复选取
            backtracking(candidates, target, sum, i);
            sum = sum - candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumNo39_advanced c = new CombinationSumNo39_advanced();
        int[] candidates = {2, 5, 3};
        List<List<Integer>> lists = c.combinationSum(candidates, 4);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
