package com.sl.arithmeticTrain;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_560
 * @Date：2024-9-12 11:23
 * @Filename：problem_560
 */
public class problem_560 {
    /**
     * 560. 和为 K 的子数组
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int [] pre = new int[n];
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        map.put(0,1);
        for(int i = 0; i < n; i++){
            if(i == 0){
                pre[i] = nums[i];
            }else{
                pre[i] = pre[i - 1] + nums[i];
            }
            if(map.containsKey(pre[i] - k)){
                res += map.get(pre[i] - k);
            }
            map.put(pre[i],map.getOrDefault(pre[i],0) + 1);
        }
        return res;
    }
}
