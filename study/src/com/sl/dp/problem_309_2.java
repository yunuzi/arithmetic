/**
 * @author 孙铃
 * @date 2025/4/29 17:26
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_309_2
 * @Date：2025/4/29
 * @Filename：problem_309_2
 */
public class problem_309_2 {
    /**
     * 309. 买卖股票的最佳时机含冷冻期
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int dp [] = new int[4];
        //持有股票
        dp [0] = -prices[0];
        //卖出股票状态
        dp [1] = 0;
        //卖出
        dp [2] = 0;
        // 冷冻期
        dp [3] = 0;

        for(int i = 1;i < prices.length;i++){
            // 卖出股票状态
            dp [0] = Math.max(Math.max(dp[0],dp[1] - prices[i]),dp[3] - prices[i]);
            dp[1] = Math.max(dp[1],dp[3]);
            dp[3] = dp[2];
            dp[2] = dp[0] + prices[i];

        }
        return Math.max(dp[1],Math.max(dp[2],dp[3]));
    }
}
