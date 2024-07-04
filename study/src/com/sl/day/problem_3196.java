package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3196
 * @Date：2024-6-26 15:32
 * @Filename：problem_3196
 */
public class problem_3196 {
    public long maximumTotalCost(int[] nums) {
        long res [] = new long[nums.length];
        res[0] = nums[0];
        if(nums.length == 1){
            return res[0];
        }
        res[1] = Math.max(nums[0] - nums[1], nums[0] + nums[1]);
        for(int i = 2; i < nums.length; i++){
            res[i] = Math.max(res[i - 1] + nums[i], res[i - 2] + nums[i - 1] - nums[i]);
        }
        return res[nums.length - 1];
    }
}
