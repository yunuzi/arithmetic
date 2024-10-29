package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_221
 * @Date：2024-8-23 16:01
 * @Filename：problem_221
 */
public class problem_221 {
    /**
     * 221. 最大正方形
     * 中等
     * 相关标签
     * 相关企业
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m + 1][n + 1];
        int max = 0;
        //我们可以发现：我们要求 matrix[i][j] 的最大边长要用到其左上角 matrix[i-1][j-1] 的最大边长，这就出现了子问题。
        // 并且其上方连续1的个数可以等价于 matrix[i-1][j] 的最大边长，左侧连续1的个数可以等价于 matrix[i][j-1] 的最大边长。
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '0') continue;
                dp[i+ 1][j + 1] = 1 + Math.min(dp[i][j],Math.min(dp[i+ 1][j],dp[i][j+1]));
                max = Math.max(max,dp[i+ 1][j + 1]);
            }
        }
        return max * max;
    }
}
