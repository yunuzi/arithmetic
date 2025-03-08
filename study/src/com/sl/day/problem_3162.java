/**
 * @author 孙铃
 * @date 2025/3/7 15:51
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3162
 * @Date：2025/3/7
 * @Filename：problem_3162
 */
public class problem_3162 {
    /**
     * 3162. 优质数对的总数 I
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
     *
     * 如果 nums1[i] 可以除尽 nums2[j] * k，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
     *
     * 返回 优质数对 的总数。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        for (int value : nums1) {
            for (int i : nums2) {
                if (value % (i * k) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
