package com.sl.Study.DP;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_198
 * @Date：2024-8-7 14:05
 * @Filename：problem_198
 */
public class problem_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int [] dp = new int[len];
        if(len == 1){
            return nums[0];
        }
        if (len == 2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[len-1];
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
