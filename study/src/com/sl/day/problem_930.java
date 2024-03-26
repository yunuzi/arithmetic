package com.sl.day;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_930
 * @Date：2024-3-4 19:16
 * @Filename：problem_930
 */
public class problem_930 {
    /**
     * 930. 和相同的二元子数组
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     *
     * 子数组 是数组的一段连续部分。
     *提示：
     *
     * 1 <= nums.length <= 3 * 104
     * nums[i] 不是 0 就是 1
     * 0 <= goal <= nums.length
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int sum = 0;
        int [] sums = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            sums[sum]++;
            sum += nums[i];
            if(sum >= goal){
                result = sums[sum - goal];
            }
        }
        return result;
    }

}
