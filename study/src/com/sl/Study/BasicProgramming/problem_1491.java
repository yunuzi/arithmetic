package com.sl.Study.BasicProgramming;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1491
 * @Date：2024-7-29 9:26
 * @Filename：problem_1491
 */
public class problem_1491 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int len = salary.length;
        int x = len - 2;
        salary[0] = 0;
        salary[len - 1] = 0;
        double sum = 0;
        for(int i = 1; i < len - 1;i++){
            sum += salary[i];
        }
        return sum / x;
    }
}
