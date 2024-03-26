package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1969
 * @Date：2024-3-20 10:39
 * @Filename：problem_1969
 */
public class problem_1969 {
    public int t(int p){
        int sum = (int) (1 + Math.pow(2, p-1) * (Math.pow(2, p-2)));
        int avg = (int) (sum / Math.pow(2, p-1));
        int zero = (int) (Math.pow(2,p -1) - avg);
        return zero;
    }
}
