package com.sl.arithmeticTrain;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2874
 * @Date：2024-7-4 19:51
 * @Filename：problem_2874
 */
public class problem_2874 {
    /**
     * 2874. 有序三元组中的最大值 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。
     *
     * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
     *
     * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
     * @param nums
     * @return
     */
    public long maximumTripletValue(int[] nums) {
        int i = nums[0];
        int j = nums[1];
        int max = i - j;
        long res = Math.max((long) max * nums[2], 0);
        for(int m = 3;m < nums.length;m++){
            i = Math.max(i, j);
            j = nums[m - 1];
            max = Math.max(max,i - j);
            res = Math.max(res, (long) max * nums[m]);
        }
        return res;
    }


    @Test
    public void test(){
        maximumTripletValue(new int[]{1000000,1,1000000});
    }
}

