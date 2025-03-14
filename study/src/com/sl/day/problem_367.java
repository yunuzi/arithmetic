/**
 * @author 孙铃
 * @date 2025/3/14 14:42
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_367
 * @Date：2025/3/14
 * @Filename：problem_367
 */
public class problem_367 {
    /**
     * 367. 有效的完全平方数
     * 简单
     * 相关标签
     * 相关企业
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     *
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     *
     * 不能使用任何内置的库函数，如  sqrt 。
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if(square == num) {
                return true;
            } else if(square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
