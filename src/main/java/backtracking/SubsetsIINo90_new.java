package backtracking;

import java.util.*;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class SubsetsIINo90_new {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        result.add(new ArrayList<>(path));
        backtracking(nums, 0);
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
    public void backtracking(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};

        SubsetsIINo90_new s = new SubsetsIINo90_new();
        List<List<Integer>> lists = s.subsetsWithDup(nums);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
