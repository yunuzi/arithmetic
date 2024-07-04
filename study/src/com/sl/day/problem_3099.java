package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3099
 * @Date：2024-7-3 9:14
 * @Filename：problem_3099
 */
public class problem_3099 {
    /**
     * 3099. 哈沙德数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
     * @param x
     * @return
     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int k = 0;
        for (int i = x; i > 0; i /= 10) {
             k+= i % 10;
        }
        return x % k == 0 ? k : -1;
    }
}
