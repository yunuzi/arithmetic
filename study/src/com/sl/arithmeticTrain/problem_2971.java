package com.sl.arithmeticTrain;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2971
 * @Date：2024-7-4 17:34
 * @Filename：problem_2971
 */
public class problem_2971 {
    /**
     * 2971. 找到最大周长的多边形
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个长度为 n 的 正 整数数组 nums 。
     *
     * 多边形 指的是一个至少有 3 条边的封闭二维图形。多边形的 最长边 一定 小于 所有其他边长度之和。
     *
     * 如果你有 k （k >= 3）个 正 数 a1，a2，a3, ...，ak 满足 a1 <= a2 <= a3 <= ... <= ak 且 a1 + a2 + a3 + ... + ak-1 > ak ，那么 一定 存在一个 k 条边的多边形，每条边的长度分别为 a1 ，a2 ，a3 ， ...，ak 。
     *
     * 一个多边形的 周长 指的是它所有边之和。
     *
     * 请你返回从 nums 中可以构造的 多边形 的 最大周长 。如果不能构造出任何多边形，请你返回 -1 。
     * @param nums
     * @return
     */
    public long largestPerimeter(int[] nums) {
//        Arrays.sort(nums);
//        long res = 0;
//        int k = nums.length;
//        for (int i = 0; i < k; i++) {
//            res += nums[i];
//        }
//        for (int i = k -1; i > 2; i--) {
//            res -= nums[i];
//            System.out.println(res);
//            if (res > nums[i]) {
//                return res + nums[i];
//            }
//        }
//        if (nums[0] + nums[1] > nums[2]) {
//            return nums[0] + nums[1] + nums[2];
//        }
//        return -1;
        int n = nums.length;
        Arrays.sort(nums);
        long sum = nums[0] + nums[1];
        long result = -1;
        for (int i = 2; i < n; i++) {
            if (sum > nums[i]) {
                result = sum + nums[i];
            }
            sum += nums[i];
        }
        return result;
    }

    @Test
    public void test(){
        long l = largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3});

    }
}
