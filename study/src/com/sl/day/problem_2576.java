package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2576
 * @Date：2024-9-12 16:12
 * @Filename：problem_2576
 */
public class problem_2576 {
    /**
     * 2576. 求出最多标记下标
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。
     *
     * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
     *
     * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
     * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
     * @param nums
     * @return
     */
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        int [] marked = new int[n];
        Arrays.sort(nums);
        int maxMarked = 0;
        int left = 0;
        int right = n / 2;
        while(left < right && right < n){
            if(nums[left] * 2 > nums[right]){
                right++;
            }else {
                marked[left] = 1;
                marked[right] = 1;
                maxMarked += 2;
                left++;
                while(left < n && marked[left] == 1){
                    left++;
                }
                right++;
            }
        }
        return maxMarked;
    }

    @Test
    public void test(){
        System.out.println(maxNumOfMarkedIndices(new int[]{2, 3, 4,5}));
    }
}
