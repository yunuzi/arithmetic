package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_198
 * @Date：2024-1-3 16:25
 * @Filename：problem_198
 */
public class problem_198 {

    /**
     * 198. 打家劫舍
     * 中等
     * 相关标签
     * 相关企业
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        //定义dp数组，dp[i] 表示在从0-i包括i的房屋内能偷取的最大金额
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int [] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for(int i = 2;i < len;i++){
            dp[i] = Math.max(dp[i - 1],(dp[i - 2] + nums[i]));
        }
        return dp[len - 1];
    }
}
