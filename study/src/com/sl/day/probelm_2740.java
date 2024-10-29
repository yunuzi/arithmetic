package com.sl.day;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：probelm_2740
 * @Date：2024-7-26 9:40
 * @Filename：probelm_2740
 */
public class probelm_2740 {
    /**
     * 2740. 找出分区值
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 正 整数数组 nums 。
     *
     * 将 nums 分成两个数组：nums1 和 nums2 ，并满足下述条件：
     *
     * 数组 nums 中的每个元素都属于数组 nums1 或数组 nums2 。
     * 两个数组都 非空 。
     * 分区值 最小 。
     * 分区值的计算方法是 |max(nums1) - min(nums2)| 。
     *
     * 其中，max(nums1) 表示数组 nums1 中的最大元素，min(nums2) 表示数组 nums2 中的最小元素。
     *
     * 返回表示分区值的整数。
     * @param nums
     * @return
     */
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length - 1;i++){
            res = Math.min(res,nums[i+1] - nums[i]);
            if(res == 0){
                return 0;
            }
        }
        return res;
    }
}
