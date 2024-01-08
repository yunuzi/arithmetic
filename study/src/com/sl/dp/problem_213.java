package com.sl.dp;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_213
 * @Date：2024-1-6 10:05
 * @Filename：problem_213
 */
public class problem_213 {
    /**
     * 213. 打家劫舍 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(len == 3){
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        //取第一个数据，不取最后一个
        int [] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        //不取第一个数据
        int [] dp2 = new int[len - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i = 2; i < len - 1; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }

        return Math.max(dp[len - 2], dp2[len - 2]);

    }

    @Test
    public void test(){
        int [] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

}
