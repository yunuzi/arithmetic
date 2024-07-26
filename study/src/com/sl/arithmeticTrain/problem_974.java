package com.sl.arithmeticTrain;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_974
 * @Date：2024-7-19 14:06
 * @Filename：problem_974
 */
public class problem_974 {
    /**
     * 974. 和可被 K 整除的子数组
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
     *
     * 子数组 是数组中 连续 的部分。
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int [] pre = new int[len];
        pre[0] = nums[0];
        for(int i = 1; i < len; i++){
            pre[i] = pre[i -1] + nums[i];
        }
        int res = 0;
        for(int i = 0; i< len; i++){
            int temp = pre[i];
            if(temp % k == 0)
                res++;
            for(int j = 0; j < i; j++){
                if((temp - pre[j]) % k == 0)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
    }
}
