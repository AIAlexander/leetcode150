package backtracking;

import java.util.*;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class NonDecreasingSubsequencesNo491 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, 0);
        return result;
    }

    /**
     * 递增子序列题目不能对数组进行排序，如果排序则会多出来一些答案，与题目不符
     * 因此去重不能使用前面所说的used方法，可以使用set
     * set去重：用于当前层的去重，比如【1，3，3】集合第二次取3，第三次就不必要取3了，因此每一层应该有个单独维护的set，因此set是一个局部变量
     * 此外题目要求递增子序列，因此取结果集时应注意
     *      1。 子序列的长度必须大于2
     *      2。 子序列的顺序是由小到大的，可以在path插入的时候进行判断，path的最后一个值是否小于当前值，如果不是说明当前遍历无需进行下去，直接进行下一次的递归
     * @param nums
     * @param index
     */
    public void backtracking(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        // set去重，set为每一层的局部变量
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // 可以保证子序列的单调递增
            if (path.size() != 0 && path.getLast() > nums[i]) {
                continue;
            }
            // set去重，当前层已经取用元素，则进行下一层的递归
            if (set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,7,6,7};
        NonDecreasingSubsequencesNo491 n = new NonDecreasingSubsequencesNo491();
        List<List<Integer>> subsequences = n.findSubsequences(nums);
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }
}
