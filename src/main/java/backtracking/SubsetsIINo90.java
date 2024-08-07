package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class SubsetsIINo90 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        result.add(new ArrayList<>(path));
        backtracking(nums, 0, used);
        return result;
    }

    /**
     * 子集去重与组合去重逻辑一致
     *      数组排序 + used数组去重
     * 区别仅在于结果的收集
     * @param nums
     * @param index
     * @param used
     */
    public void backtracking(int[] nums, int index, boolean[] used) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};

        SubsetsIINo90 s = new SubsetsIINo90();
        List<List<Integer>> lists = s.subsetsWithDup(nums);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
