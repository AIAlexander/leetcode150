package array;

/**
 * @author wsh
 * @date 2024/1/3
 */
public class BestTimeBuySellStockNo121 {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = Integer.MIN_VALUE;

        while (left < right && right != prices.length) {
            if (prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return profit == Integer.MIN_VALUE ? 0 : profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,6,5,4,3,2};
        System.out.println(maxProfit(prices));
    }
}
