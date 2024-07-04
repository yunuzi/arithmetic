package com.sl.arithmeticTrain;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_1679
 * @Date：2024-7-3 9:26
 * @Filename：problem_1679
 */
public class problem_1679 {
    /**
     * 1679. K 和数对的最大数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums 和一个整数 k 。
     *
     * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
     *
     * 返回你可以对数组执行的最大操作数
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while(l < r){
            if(nums[l] > k){
                break;
            }
            if(nums[l] + nums[r] == k){
                count++;
                l++;
                r--;
            } else if (nums[l] + nums[r] > k) {
                r--;
            }else {
                l++;
            }
        }
        return count;
    }
}
