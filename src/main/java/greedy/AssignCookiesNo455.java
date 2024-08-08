package greedy;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class AssignCookiesNo455 {

    /**
     * 贪心策略：
     *      尽量使用大的饼干满足胃口大的小孩
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            while (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AssignCookiesNo455 a = new AssignCookiesNo455();
        int[] g = {1,2,7,10};
        int[] s = {1,3,5,9};

        System.out.println(a.findContentChildren(g, s));
    }
}
