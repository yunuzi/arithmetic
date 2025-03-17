/**
 * @author 孙铃
 * @date 2024/11/6 20:32
 */
package com.sl.day;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_633
 * @Date：2024/11/6
 * @Filename：problem_633
 */
public class problem_633 {
    /**
     *633. 平方数之和
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
//        int left = 0;
//        int right = c;
//        while(left <= right) {
//            int mid = left + (right -left) / 2;
//            long square = (long) mid * mid;
//            if(c >= square) {
//                if(c == square) {
//                    return true;
//                }
//                boolean perfectSquare = isPerfectSquare((int) (c - square));
//                if(perfectSquare) {
//                    return true;
//                }
//                left++;
//            }else {
//                right = mid - 1;
//            }
//        }
//        return false;

        int max = (int)Math.sqrt(c);
        int left = 0;
        int right = max;
        int findNum = c - right*right;
        while (left <= right) {
            if (left * left < findNum) {
                left++;
            } else if (left * left > findNum) {
                right--;
                findNum = c - right*right;
            } else {
                return true;
            }
        }
        return false;
    }
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
                right = mid -1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(judgeSquareSum(10000000));
    }
}
