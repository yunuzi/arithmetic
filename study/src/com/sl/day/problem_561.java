/**
 * @author 孙铃
 * @date 2025/2/25 10:00
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_561
 * @Date：2025/2/25
 * @Filename：problem_561
 */
public class problem_561 {
    /**
     * 561. 数组拆分
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     *
     * 返回该 最大总和 。
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;

        //更快

//        if (nums.length < 1800) {
//            Arrays.sort(nums);
//            int n = nums.length;
//            int sum = 0;
//            for (int i = 0; i < n; i += 2) {
//                sum += nums[i];
//            }
//            return sum;
//        } else {
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (int num : nums) {
//                min = Math.min(min, num);
//                max = Math.max(max, num);
//            }
//            int[] cntMap = new int[max - min + 1];
//            for (int num : nums) {
//                cntMap[num - min]++;
//            }
//            int prev = 0;
//            int sum = 0;
//            for (int i = min; i <= max; i++) {
//                int cnt = cntMap[i - min];
//                sum += (cnt + 1 - prev >> 1) * i;
//                prev = cnt - prev & 1;
//            }
//            return sum;
//        }
    }
}
