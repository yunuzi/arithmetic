package com.sl.Study.DP;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_62
 *
 *
 * @Date：2024-8-7 15:12
 * @Filename：problem_62
 */
public class problem_62 {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        //数组初始化
        dp[0][0] = 1;
        for(int i = 1;i < m;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i < n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
