/**
 * @author 孙铃
 * @date 2024/11/6 19:56
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3254
 * @Date：2024/11/6
 * @Filename：problem_3254
 */
public class problem_3254 {
    /**
     * 3254. 长度为 K 的子数组的能量值 I
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
     *
     * 一个数组的 能量值 定义为：
     *
     * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
     * 否则为 -1 。
     * 你需要求出 nums 中所有长度为 k 的
     * 子数组
     *  的能量值。
     *
     * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray(int[] nums, int k) {
        int n  = nums.length;
        if(n == 1) {
            return new int[]{nums[0]};
        }
        int [] res = new int[n-k+1];
        Arrays.fill(res,-1);
        int pre = nums[0];
        int left = 0;
        int temp = 1;
        for(int i = 1; i < n; i++) {
            if(temp >= k) {
                res[i - k] = nums[i -1];
                pre = nums[i -1];
            }
            if(nums[i] - 1 == pre) {
                temp++;
                pre = nums[i];
            }else {
                temp = 1;
                pre = nums[i];
            }
        }
        if(temp >= k) {
            res[n - k] = nums[n - 1];
        }
        return res;
    }
}
