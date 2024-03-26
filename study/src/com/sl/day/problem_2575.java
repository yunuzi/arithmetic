package com.sl.day;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2575
 * @Date：2024-3-7 15:30
 * @Filename：problem_2575
 */
public class problem_2575 {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int div[] = new int[len];
        int x = 0;
        for(int i = 1;i <= len;i++){
            x = (x*10 + Integer.parseInt(word.substring(i - 1,i))) % m;
            div[i - 1] = x == 0 ? 1 : 0;
        }
        return div;
    }


    @Test
    public void test(){
        System.out.println(divisibilityArray("998244353", 3));
    }


}
