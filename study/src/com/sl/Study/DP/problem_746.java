package com.sl.Study.DP;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_746
 * @Date：2024-8-7 13:53
 * @Filename：problem_746
 */
public class problem_746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int [] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i <= len ;i++){
            dp[i] = Math.min(dp[i -1] + cost[i -1],dp[i - 2] + cost[i-2]);
        }
        return dp[len];
    }
}
