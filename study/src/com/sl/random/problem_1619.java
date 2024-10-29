/**
 * @author 孙铃
 * @date 2024/10/18 14:56
 */
package com.sl.random;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_1619
 * @Date：2024/10/18
 * @Filename：problem_1619
 */
public class problem_1619 {
    public double trimMean(int[] arr) {
        int len = arr.length;
        int deelt = Integer.valueOf ((int) (len * 0.05));
        int total = 0;
        int pre = 0;
        int end = 0;
        Arrays.sort(arr);
        for(int i = 0;i < len;i++){
            if(i < deelt){
                pre +=  arr[i];
            }
            if(i >= len - deelt){
                end += arr[i];
            }
            total += arr[i];
        }
        return (double)(total - pre - end) / (double) (len - 2 * deelt);
    }

    @Test
    public void test(){
        int[] arr = new int[]{9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3};
        double i = trimMean(arr);
        System.out.println(i);
    }
}
