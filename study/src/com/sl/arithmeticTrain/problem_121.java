package com.sl.arithmeticTrain;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_121
 * @Date：2024-7-2 14:06
 * @Filename：problem_121
 */
public class problem_121 {

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for(int i = 1;i < prices.length;i++){
            res = Math.max(res,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return res;
    }
}
