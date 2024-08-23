package com.sl.Study.BasicProgramming;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_976
 * @Date：2024-7-29 9:30
 * @Filename：problem_976
 */
public class problem_976 {
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = len - 1; i >= 2; i--){
            if(nums[i] < nums[i - 1] + nums[i - 2]){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
