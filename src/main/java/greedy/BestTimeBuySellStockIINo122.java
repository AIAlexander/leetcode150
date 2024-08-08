package greedy;

/**
 * @author wsh
 * @date 2024/8/7
 */
public class BestTimeBuySellStockIINo122 {

    /**
     * 买卖股票II，可使用贪心算法解决，股票可以隔一天买卖
     * 贪心策略：
     *      一天买，下一天卖，获得所有的利润，只要利润是正的，就加到sum中，就是最大的利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;
        int result = 0;
        while (end < prices.length) {
            int profit = prices[end] - prices[start];
            // 当天的股价 - 前一天的股价只要是正数，就汇总利润
            if (profit >= 0) {
                result += profit;
            }
            start++;
            end++;
        }
        return result;
    }
}
