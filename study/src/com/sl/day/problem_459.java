package com.sl.day;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_459
 * @Date：2024-6-18 10:56
 * @Filename：problem_459
 */
public class problem_459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if(length == 1){
            return false;
        }
        int[] next = new int[length];
        int max = getNext(next, s);
        if(max == 0){
            return false;
        }
        String substring = s.substring(0, length - max);
        String substring1 = s.substring(max, length);
        if(substring.contains(substring1)){
            return true;
        }

        return false;

    }


    public int getNext(int[] next, String string){
        //abcabc
        char[] chars = string.toCharArray();
        int length = chars.length;

        int max = 0;
        //对next数组初始化
        next[0] = 0;
        int j = 0;

        for (int i = 1; i < length; i++) {

            //如果j 与 i 位置不相等， 则 j 向前回退
            while(j > 0 && chars[j] != chars[i]){
                j = next[j - 1];
            }

            //如果j 与 i 位置相等,则j++
            if(chars[j] == chars[i]){
                j++;
            }

            //给next数组赋值
            next[i] = j;
            if(j > max){
                max = j;
            }


        }
        return max;
    }


    @Test
    public void test(){
        repeatedSubstringPattern("aba");
    }
}
