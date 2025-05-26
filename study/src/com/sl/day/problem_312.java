/**
 * @author 孙铃
 * @date 2025/5/26 15:46
 */
package com.sl.day;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_312
 * @Date：2025/5/26
 * @Filename：problem_312
 */
public class problem_312 {
    /**
     * 312. 戳气球
     * 困难
     * 相关标签
     * 相关企业
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     *
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
     * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     *
     * 求所能获得硬币的最大数量。
     * @param nums
     * @return
     *
     * n == nums.length
     * 1 <= n <= 300
     * 0 <= nums[i] <= 100
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][] dp = new int[n+2][n+2];
        int nums_new[] = new int[n+2];
        nums_new[0] = nums_new[n+1] = 1;
        for(int i = 1; i <= n; i++) {
            nums_new[i] = nums[i-1];
        }
        for(int len = 3; len <= n+2; len++) {
            for(int l = 0;l + len - 1<= n + 1;l++) {
                int r = l + len - 1;
                for(int k = l+1;k <= r-1;k++) {
                    dp[l][r] = Math.max(dp[l][r],dp[l][k] + dp[k][r] + nums_new[l] * nums_new[k] * nums_new[r]);
                }
            }
        }
        return dp[0][n+1];
    }

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
