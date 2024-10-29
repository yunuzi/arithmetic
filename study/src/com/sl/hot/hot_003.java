package com.sl.hot;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_3
 * @Date：2024-3-8 17:03
 * @Filename：hot_3
 */
public class hot_003 {
    /**
     * 128. 最长连续序列
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int x : nums){
                if(!set.contains(x)){
                    set.add(x);
                }
            }

            int max = 1;
            int count = 1;
            for(int x : set){
                if(!set.contains(x-1)){
                    count = 1;
                    while(set.contains(x+count)){
                        count++;
                    }
                    max = Math.max(max, count);
                }
            }
            return max;
    }

    @Test
    public void test(){
        longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }
}
