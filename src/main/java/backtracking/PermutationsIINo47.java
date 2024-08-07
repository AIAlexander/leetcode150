package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class PermutationsIINo47 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    /**
     * 通过used数组进行数层、树枝的去重。数组顺序需要排列
     * @param nums
     * @param used
     */
    public void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 树枝的去重，防止排列问题中取到相同的元素
            if (used[i]) {
                continue;
            }
            // 数层的去重，即[1,1,2]中第二个1需要跳过
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PermutationsIINo47 p = new PermutationsIINo47();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = p.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
