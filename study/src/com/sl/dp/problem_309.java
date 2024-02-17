package com.sl.dp;

/**
 *
 * 309. 买卖股票的最佳时机含冷冻期
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_309
 * @Date：2024-1-26 10:26
 * @Filename：problem_309
 */
public class problem_309 {
    public int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i][0], dp[i][1] - prices[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i][0] + prices[i]);

            if(dp[i][0] + prices[i] > dp[i-1][0]){
               i += 1;
            }

        }

        return dp[prices.length-1][1];

    }
}
