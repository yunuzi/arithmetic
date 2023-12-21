package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_53
 * @Date：2023-12-18 13:20
 * @Filename：problem_53
 */
public class problem_53 {
    /**
     * 53. 最大子数组和
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            //如果区间累加值大于res，则收集
            if(cur > res){
                res =cur;
            }
            //如果区间累加值小于0，则将区间累加值设置为0，重新从i + 1处进行累加
            if(cur < 0){
                cur = 0;
            }

        }
        return res;
    }
}
