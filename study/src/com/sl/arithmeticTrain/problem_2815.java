package com.sl.arithmeticTrain;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2815
 * @Date：2024-7-1 14:02
 * @Filename：problem_2815
 */
public class problem_2815 {

    /**
     * 2815. 数组中的最大数对和
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
     *
     * 返回最大和，如果不存在满足题意的数字对，返回 -1
     * @param nums
     * @return
     */
    public int maxSum(int[] nums) {
        int ans = -1;
        int[] maxVal = new int[10];
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        for (int v : nums) {
            int maxD = 0;
            for (int x = v; x > 0; x /= 10)
                maxD = Math.max(maxD, x % 10);
            ans = Math.max(ans, v + maxVal[maxD]);
            maxVal[maxD] = Math.max(maxVal[maxD], v);
        }
        return ans;
    }
}
