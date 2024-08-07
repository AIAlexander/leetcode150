package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class SubsetsNo78 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtracking(nums, 0);
        return result;
    }

    /**
     * 子集问题思路与回溯算法思路一样，只是收集结果与别的不同
     * 收集结果在各个节点处都需要收集结果
     * @param nums
     * @param index
     */
    public void backtracking(int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            // 各个节点都需要收集结果
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsNo78 s = new SubsetsNo78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = s.subsets(nums);
        for (int i = 0; i < subsets.size(); i++) {
            System.out.println(subsets.get(i));
        }
    }
}
