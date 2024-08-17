package multi_dimensional;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    // 买卖股票的最佳时机 III
    // 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    // 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    public int maxProfit(int times, int[] prices) {
        int[] buy = new int[times + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[times + 1];

        int days = prices.length;
        for (int day = 0; day < days; day++) {
            int price = prices[day];
            for (int i = 1; i <= times; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price); // 必须先卖了之前的
                sell[i] = Math.max(sell[i], buy[i] + price); // 可以在同一天买入卖出
            }
        }
        return sell[times];
    }
}
