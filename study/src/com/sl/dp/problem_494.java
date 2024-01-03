package com.sl.dp;



/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_494
 * @Date：2024-1-2 10:23
 * @Filename：problem_494
 */

public class problem_494 {
    /**
     * 494. 目标和
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个非负整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        //如果target过大 sum将无法满足
        if ( target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int left = (sum + target) / 2;
        if(left < 0) left = - left;
        int [] dp = new int[left + 1];
        dp[0] = 1;
        for(int i = 0;i < nums.length;i++){
            for(int j = left;j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}

