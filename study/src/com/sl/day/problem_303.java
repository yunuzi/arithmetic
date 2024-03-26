package com.sl.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_303
 * @Date：2024-3-18 9:41
 * @Filename：problem_303
 */
public class problem_303 {
    /**
     * 303. 区域和检索 - 数组不可变
     * 简单
     * 相关标签
     * 相关企业
     * 给定一个整数数组  nums，处理以下类型的多个查询:
     *
     * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     * 实现 NumArray 类：
     *
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     * @param
     */
    class NumArray {
        private final int[] sum;

        public NumArray(int[] nums) {
            this.sum = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                sum[i+1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right+1] - sum[left];
        }
    }
}
