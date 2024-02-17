package com.sl.dp;

/**
 * 188. 买卖股票的最佳时机 IV
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_188
 * @Date：2024-1-26 10:05
 * @Filename：problem_188
 */
public class problem_188 {
    public int maxProfit(int k, int[] prices) {
        int [] dp = new int[2*k + 1];
        for(int i = 0; i < (2*k+1); i++){
           if(i % 2 != 0){
               dp[i] = -prices[0];
           }
        }
        for(int i = 1;i < prices.length;i++){
          for(int j = 1;j < (2*k+1);j++){
              if(j % 2 == 0){
                  dp[j] = Math.max(dp[j],dp[j-1] + prices[i]);
              } else if (j % 2 == 1) {
                  dp[j] = Math.max(dp[j],dp[j-1] - prices[i]);
              }
          }
        }

        return dp[2*k];
    }

}
