package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class PermutationsNo46 {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    /**
     * 排列问题，是可以取当前元素之前的元素，这与组合问题不同
     *      即：[1,2,3] 在排列问题中：取2之后，可选的元素是：[1,3]
     *                 在组合问题中：取2之后，可选的元素是：[3]，因为在组合中[1,2]和[2,1]是同一个组合，因此需要去重
     * 因此在排列问题中，需要做的是树枝层面的去重，即路径上的节点不能重复取了
     *      比如：【1，2，3】中取了2，那么可选值是【1，3】，节点2不能再取了
     * @param nums
     */
    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 直接使用path进行去重
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PermutationsNo46 p = new PermutationsNo46();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = p.permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
