package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_518
 * @Date：2024-1-3 9:55
 * @Filename：problem_518
 */
public class problem_518 {

    /**
     * 518. 零钱兑换 II
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     *
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     *
     * 假设每一种面额的硬币有无限个。
     *
     * 题目数据保证结果符合 32 位带符号整数。
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int [] dp = new int[amount + 1];
        dp [0] = 1;
        for(int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];

    }
}
