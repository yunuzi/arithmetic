package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2529
 * @Date：2024-4-9 13:16
 * @Filename：problem_2529
 */
public class problem_2529 {
    /**
     * 2529. 正整数和负整数的最大计数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
     *
     * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
     * 注意：0 既不是正整数也不是负整数。
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        // 第一个 > 0 的位置，等价于第一个 >= 1 的位置
        int pos = nums.length - lowerBound(nums, 1);
        return Math.max(neg, pos);
    }

    // 返回 nums 中第一个 >= target 的数的下标
    // 如果不存在这样的数，返回 nums.length
    private int lowerBound(int[] nums, int target) {
        // 二分范围：开区间 (left, right)
        int left = -1;
        int right = nums.length;
        // 开区间不为空
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 二分范围缩小至 (left, mid)
                right = mid;
            } else {
                // 二分范围缩小至 (mid, right)
                left = mid;
            }
        }
        // 此时 left 等于 right - 1
        // 因为 nums[right - 1] < target 且 nums[right] >= target，所以答案是 right
        return right;
    }
}
