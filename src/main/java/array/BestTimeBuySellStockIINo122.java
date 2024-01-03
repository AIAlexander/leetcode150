package array;

/**
 * @author wsh
 * @date 2024/1/3
 */
public class BestTimeBuySellStockIINo122 {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;
        while (left < right && right != prices.length) {
            if (prices[left] < prices[right]) {
                profit += (prices[right] - prices[left]);
            }
            left++;
            right++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
