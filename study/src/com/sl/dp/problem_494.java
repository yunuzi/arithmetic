package com.sl.dp;


import java.util.Arrays;

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

    private int []num;
    private int [][]memo;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }

        sum -= Math.abs(target);
        if(sum < 0 || sum % 2 == 1) {
            return 0;
        }

        //背包容量
        int m = sum / 2;
        this.num = nums;
        this.memo = new int[nums.length][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(nums.length - 1,m);
    }

    private int dfs(int i, int m) {
        if(i < 0) {
            return m == 0 ? 1 : 0;
        }
        if(memo[i][m] != -1) { //被选过，直接跳过
            return memo[i][m];
        }

        if(m < num[i]) {//超过背包容量，不能选
            return memo[i][m] = dfs(i -1,m);
        }

        //选和不选加一起
        return memo[i][m] = dfs(i-1,m) + dfs(i -1,m - num[i]);
    }

}

