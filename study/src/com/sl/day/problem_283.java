package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_283
 * @Date：2024-6-18 15:09
 * @Filename：problem_283
 */
public class problem_283 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        for(;fast<nums.length;fast++){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
        }
        for(;slow<nums.length;slow++){
            nums[slow] = 0;
        }
    }
}
