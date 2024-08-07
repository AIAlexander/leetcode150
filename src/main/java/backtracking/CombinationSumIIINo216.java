package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class CombinationSumIIINo216 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }


    public void backtracking(int k, int n, int index, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝优化1
        for (int i = index; i <= (9 - (k - path.size()) + 1); i++) {
            // 剪枝优化2，因为是按从小到大排序，如果当前数值和已超过9，后序的数值无需递归，可剪枝
            if (sum < n) {
                path.add(i);
                sum = sum + i;
                backtracking(k, n, i + 1, sum);
                Integer last = path.removeLast();
                sum = sum - last;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIIINo216 c = new CombinationSumIIINo216();
        List<List<Integer>> lists = c.combinationSum3(3, 9);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
