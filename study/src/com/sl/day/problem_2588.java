/**
 * @author 孙铃
 * @date 2025/3/6 9:09
 */
package com.sl.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2588
 * @Date：2025/3/6
 * @Filename：problem_2588
 */
public class problem_2588 {
    /**
     * 2588. 统计美丽子数组数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
     *
     * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
     * 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。
     * 将 nums[i] 和 nums[j] 都减去 2k 。
     * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
     *
     * 请你返回数组 nums 中 美丽子数组 的数目。
     *
     * 子数组是一个数组中一段连续 非空 的元素序列。
     * @param nums
     * @return
     */
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1); // 预分配空间
        cnt.put(0, 1);
        for (int x : nums) {
            s ^= x; // 异或
            int c = cnt.getOrDefault(s, 0);
            ans += c;
            cnt.put(s, c + 1);
        }
        return ans;
    }
}
