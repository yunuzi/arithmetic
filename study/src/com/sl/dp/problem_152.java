/**
 * @author 孙铃
 * @date 2025/5/16 16:10
 */
package com.sl.dp;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_152
 * @Date：2025/5/16
 * @Filename：problem_152
 */
public class problem_152 {
    /**
     * 152. 乘积最大子数组
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for(int i = 1;i < nums.length;i++) {
            int temp = max;
            //必须要选择nums[i]
            max = Math.max(nums[i],Math.max(nums[i]*min,nums[i]*max));
            min = Math.min(nums[i],Math.min(nums[i]*min,nums[i]*temp));
            res = Math.max(res,max);
        }
        return res;
    }

}
