package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：problem_738
 * @Date：2023-12-21 20:12
 * @Filename：problem_738
 */
public class problem_738 {

    /**
     * 738. 单调递增的数字
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
     *
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {//当前一个大于后一个数字时，则将前一个数--，更新开始变为9的位置
                chars[i]--;//将当前数--，用于后面的判断中
                start = i+1;
            }
        }

        //从开始变为9的位置给数赋值为9
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

}
