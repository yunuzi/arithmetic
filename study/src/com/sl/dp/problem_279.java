package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_279
 * @Date：2024-1-3 11:18
 * @Filename：problem_279
 */
public class problem_279 {
    /**
     * 279. 完全平方数
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        double sqrt = Math.sqrt(n);
        int m = (int) sqrt;
        int []dp = new int[n + 1];
        for(int i = 0;i <= n;i++){
            dp[i] = max;
        }
        dp[0] = 0;
        for(int i = 0;i <= m;i++){
            for(int j = i*i;j <= n;j++){
                if(dp[j - i*i] != max){
                    dp[j] = Math.min(dp[j],dp[j - i*i] + 1);
                }
            }
        }
        return dp[n];
    }
}
