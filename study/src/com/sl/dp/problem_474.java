package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_474
 * @Date：2024-1-3 9:24
 * @Filename：problem_474
 */
public class problem_474 {
    /**
     * 474. 一和零
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
      int [][] dp = new int[m + 1][n + 1];
      for(String str : strs){
          int zero = 0;
          int one = 0;
          for(char chr : str.toCharArray()){
              if(chr == '0'){
                  zero++;
              }else {
                  one++;
              }
          }
          for(int i = m;i >= zero;i--){
              for (int j = n; j >= one ; j--) {
                  dp[i][j] = Math.max(dp[i][j],dp[i - zero][j-one] + 1);
              }
          }
      }
    return dp[m][n];
    }
}
