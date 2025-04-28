/**
 * @author 孙铃
 * @date 2025/4/28 14:15
 */
package com.sl.dp;

import java.util.HashMap;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1218
 * @Date：2025/4/28
 * @Filename：problem_1218
 */
public class problem_1218 {
    /**
     * 1218. 最长定差子序列
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
     *
     * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,3,4], difference = 1
     * 输出：4
     * 解释：最长的等差子序列是 [1,2,3,4]。
     * 示例 2：
     *
     * 输入：arr = [1,3,5,7], difference = 1
     * 输出：1
     * 解释：最长的等差子序列是任意单个元素。
     * 示例 3：
     *
     * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
     * 输出：4
     * 解释：最长的等差子序列是 [7,5,3,1]。
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 105
     * -104 <= arr[i], difference <= 104
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {//跟300题一样，只是需要记录最长子序列的长度
        // 使用 HashMap 优化时间复杂度
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = 1;

        for (int num : arr) {
            int prevNum = num - difference;
            int currentLength = dp.getOrDefault(prevNum, 0) + 1;
            dp.put(num, currentLength);
            res = Math.max(res, currentLength);
        }

        return res;
    }
}
