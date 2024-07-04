package com.sl.day;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3115
 * @Date：2024-7-2 14:23
 * @Filename：problem_3115
 */
public class problem_3115 {
    /**
     *3115. 质数的最大距离
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums。
     *
     * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
     * @param nums
     * @return
     */
    public int maximumPrimeDifference(int[] nums) {
        int l = -1;
        int r = -1;
        for(int i = 0;i < nums.length;i++){
            if(check(nums[i])){
                if(l == -1){
                    l = i;
                }
                r = i;
            }
        }
        return r - l;
    }

    //判断是否是质数
    public Boolean check(int num){
        if(num == 1){
            return false;
        }
        if(num == 2){
            return true;
        }
        for(int i = 2;i < num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
