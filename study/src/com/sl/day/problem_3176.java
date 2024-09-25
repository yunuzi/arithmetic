package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3176
 * @Date：2024-9-6 11:34
 * @Filename：problem_3176
 */
public class problem_3176 {
    /**
     * 3176. 求出最长好子序列 I
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
     *
     * 请你返回 nums 中 好
     * 子序列
     *  的最长长度
     * @param nums
     * @param k
     * @return
     */
    public int maximumLength(int[] nums, int k) {
        int [][] dp = new int[nums.length][k + 1];
        for(int i = 0; i < k+1; i++){
            dp[0][i] = 1;
        }
        int ans = dp[0][k];
        for(int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = 1;
                for (int m = i - 1; m >= 0; m--) {
                    if (nums[i] == nums[m]) {
                        dp[i][j] = Math.max(dp[i][j], dp[m][j] + 1);
                    } else {
                        if (j >= 1) {
                            dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + 1);
                        }
                    }
                }
            }
            ans = Math.max(ans, dp[i][k]);
        }
        return ans;
    }
}
