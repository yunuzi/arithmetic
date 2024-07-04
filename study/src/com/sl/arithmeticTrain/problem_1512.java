package com.sl.arithmeticTrain;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_1512
 * @Date：2024-7-1 13:55
 * @Filename：problem_1512
 */
public class problem_1512 {
    /**
     *1512. 好数对的数目
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums 。
     *
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     *
     * 返回好数对的数目。
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res += map.get(nums[i]);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return res;
    }

}
