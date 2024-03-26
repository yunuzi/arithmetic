package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2789
 * @Date：2024-3-14 9:16
 * @Filename：problem_2789
 */
public class problem_2789 {
    /**
     * 2789. 合并后数组中的最大元素
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
     *
     * 你可以在数组上执行下述操作 任意 次：
     *
     * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
     * 返回你可以从最终数组中获得的 最大 元素的值。
     * @param nums
     * @return
     */
    public long maxArrayValue(int[] nums) {
        int len = nums.length;
        long max = nums[len - 1];
        for(int i = len - 2; i >= 0; i--){
            max = max - nums[i] >= 0 ? max + nums[i] : nums[i];
        }
        return max;
    }
}
