/**
 * @author 孙铃
 * @date 2025/4/21 13:37
 */
package com.sl.day;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2146
 * @Date：2025/4/21
 * @Filename：problem_2146
 */
public class problem_2146 {

    /**
     *2145. 统计隐藏数组数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始且长度为 n 的整数数组 differences ，它表示一个长度为 n + 1 的 隐藏 数组 相邻 元素之间的 差值 。
     * 更正式的表述为：我们将隐藏数组记作 hidden ，那么 differences[i] = hidden[i + 1] - hidden[i] 。
     *
     * 同时给你两个整数 lower 和 upper ，它们表示隐藏数组中所有数字的值都在 闭 区间 [lower, upper] 之间。
     *
     * 比方说，differences = [1, -3, 4] ，lower = 1 ，upper = 6 ，那么隐藏数组是一个长度为 4 且所有值都在 1 和 6 （包含两者）之间的数组。
     * [3, 4, 1, 5] 和 [4, 5, 2, 6] 都是符合要求的隐藏数组。
     * [5, 6, 3, 7] 不符合要求，因为它包含大于 6 的元素。
     * [1, 2, 3, 4] 不符合要求，因为相邻元素的差值不符合给定数据。
     * 请你返回 符合 要求的隐藏数组的数目。如果没有符合要求的隐藏数组，请返回 0 。
     * @param differences
     * @param lower
     * @param upper
     * @return
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {//0 1 -2 2
//        //查找到最大和最小值就解决问题了
//        int len = differences.length + 1;
//        long arr[] = new long[len];
//        //让arr第一个设置为0
//        arr[0] = 0;
//        int res = 0;
//        long max = arr[0];
//        long min = arr[0];
//        for(int i = 1; i < len; i++) {
//            arr[i] = differences[i - 1] + arr[i - 1];
//            //取到最大和最小值
//            max = Math.max(max, arr[i]);
//            min = Math.min(min, arr[i]);
//        }
//        long minAdd = lower - min;
//
//        long maxAdd = upper - max;
//
//        if(max + minAdd > upper || min + maxAdd  < lower) {
//            return res;
//        }
//        while(max + minAdd <= upper && min + maxAdd  >= lower) {
//            res++;
//            minAdd++;
//            maxAdd++;
//        }
//        return res;

        // 累加数组，把最小值赋给lower，检查最大值是否小于等于upper
        int minValue = 0;
        int maxValue = 0;
        int current = 0;
        for (int num : differences) {
            current += num;
            minValue = Math.min(minValue, current);
            maxValue = Math.max(maxValue, current);

            // 提前退出：如果累积差值范围已经超过 [lower, upper] 区间长度
            if (maxValue - minValue > upper - lower) {
                return 0;
            }
        }
        // 计算并返回合法隐藏数组的数量
        return (upper - lower) - (maxValue - minValue) + 1;
    }

    @Test
    public void test() {
        System.out.println(numberOfArrays(new int[]{100000,100000,100000,100000,100000}, -1000, 1000));
    }
}
