package com.sl.dp;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_416
 * @Date：2023-12-27 14:04
 * @Filename：problem_416
 */
public class problem_416 {
    /**
     * 416. 分割等和子集
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int [] dp = new int[target + 1];
        dp[0] = 0;
        for(int i = 0; i < nums.length;i++){
            for(int j = target;j >= nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        if(dp[target] == target){
            return true;
        }
        return false;

    }

}
