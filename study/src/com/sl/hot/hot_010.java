package com.sl.hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_010
 * @Date：2024-3-14 10:24
 * @Filename：hot_010
 */
public class hot_010 {
    /**
     * 560. 和为 K 的子数组
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
//        int res = 0;
//        if(nums[0] == k){
//            res++;
//        }
//        for(int i =0;i < nums.length;i++){
//            int sum = 0;
//            for(int j = i;j >= 0;j--){
//                sum += nums[j];
//                if(k == sum){
//                    res++;
//                }
//            }
//        }
//        return res;

        int n = nums.length;
        int result = 0;
        int[] pre = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0;i < n; ++i) {
            if (i == 0) {
                pre[0] = nums[0];
            } else {
                pre[i] = pre[i - 1] + nums[i];
            }
            if (map.containsKey(pre[i] - k)) {
                result += map.get(pre[i] - k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return result;
    }



    @Test
    public void test(){
        subarraySum(new int[]{1,2,3},3);
    }
}
