package com.sl.arithmeticTrain;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2389
 * @Date：2024-7-16 13:57
 * @Filename：problem_2389
 */
public class problem_2389 {
    /**
     * 2389. 和有限的最长子序列
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
     *
     * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
     *
     * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int prefixSum[] = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 0;i < nums.length;i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res[] = new int[queries.length];
        for(int i = 0; i < queries.length;i++){
            int temp = queries[i];
            if(temp >= prefixSum[prefixSum.length - 1]){
                res[i] = prefixSum.length - 1;
                continue;
            }
            for(int j = 1;j < prefixSum.length;j++){
                if(prefixSum[j] > temp){
                    res[i] = j - 1;
                    break;
                }
            }
        }
        return res;
    }
}
