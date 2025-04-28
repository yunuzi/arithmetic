/**
 * @author 孙铃
 * @date 2025/4/28 11:14
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_673
 * @Date：2025/4/28
 * @Filename：problem_673
 */
public class problem_673 {
    /**
     * 73. 最长递增子序列的个数
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     *
     * 注意 这个数列必须是 严格 递增的。
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 2000
     * -10^6 <= nums[i] <= 10^6
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        //定义一个dp[i] 表示以nums[i]结尾的最长递增子序列的长度 ，count[i]表示 count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数。
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        int max =1;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
        }
        if(nums.length == 1) {
            return 1;
        }
        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else {
                        if(dp[j] + 1 == dp[i]) {
                            count[i] += count[j];
                        }
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        int res = 0;

        for(int i = 0; i < n; i++) {
            if(dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
