package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_122
 * @Date：2024-1-8 16:36
 * @Filename：problem_122
 */
public class problem_122 {

    /**
     * 122. 买卖股票的最佳时机 II
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int [][] dp = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            if(i == 0){
                dp[i][0] = -prices[i];
                dp[i][1] = 0;
                continue;
            }
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);//卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);//买入
        }

        return dp[prices.length - 1][1];

    }
}
