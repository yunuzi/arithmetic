package com.sl.Study.DP;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_70
 * @Date：2024-8-5 11:41
 * @Filename：problem_70
 */
public class problem_70 {
    /**
     * 70. 爬楼梯
     * 已解答
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int []dp = new int[n];
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n -1];
    }
}
