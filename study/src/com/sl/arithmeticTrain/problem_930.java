package com.sl.arithmeticTrain;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_930
 * @Date：2024-9-12 9:53
 * @Filename：problem_930
 */
public class problem_930 {
    /**
     * 930. 和相同的二元子数组
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     *
     * 子数组 是数组的一段连续部分。
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int sum = 0;
        int [] sums = new int[nums.length + 1];
        for(int i = 0;i < nums.length;i++){
            sums[sum]++;
            sum += nums[i];
            if(sum >= goal){
                result += sums[sum - goal];
            }
        }
        return result;
    }
}
