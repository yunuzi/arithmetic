package com.sl.Study.DP;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_64
 * @Date：2024-8-8 10:34
 * @Filename：problem_64
 */
public class problem_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        //初始化dp数组
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m;i++){
            dp[i][0] = dp[i -1][0] + grid[i][0];
        }
        for(int i = 1;i < n;i++){
            dp[0][i] = dp[0][i -1] + grid[0][i];
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i -1][j] + grid[i][j],dp[i][j -1] + grid[i][j]);
            }
        }
        return dp[m -1][n -1];
    }
}
