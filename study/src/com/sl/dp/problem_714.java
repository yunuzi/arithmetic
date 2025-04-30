/**
 * @author 孙铃
 * @date 2025/4/29 18:06
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_714
 * @Date：2025/4/29
 * @Filename：problem_714
 */
public class problem_714 {
    /**
     * 714. 买卖股票的最佳时机含手续费
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int dp[] = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1;i < prices.length;i++) {
            dp[0] = Math.max(dp[0],dp[1] - prices[i]);

            dp[1] = Math.max(dp[1],dp[0] + prices[i] -fee);
        }

        return dp[1];
    }
}
