package com.sl.hot;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：p_001
 * @Date：2024-3-8 16:29
 * @Filename：p_001
 */
public class hot_001 {
    /**
     * 1. 两数之和
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i],i);
        }
        return null;
    }
}
