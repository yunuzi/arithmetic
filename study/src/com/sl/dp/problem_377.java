package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_377
 * @Date：2024-1-3 10:08
 * @Filename：problem_377
 */
public class problem_377 {

    /**
     * 377. 组合总和 Ⅳ
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * 题目数据保证答案符合 32 位整数范围。
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1;i <= target;i++){
            for(int j = 0;j < nums.length;j++){
               if(i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
