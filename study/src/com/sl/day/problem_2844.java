package com.sl.day;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2844
 * @Date：2024-7-25 10:52
 * @Filename：problem_2844
 */
public class problem_2844 {
    /**
     * 2844. 生成特殊数字的最少操作
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
     *
     * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
     *
     * 返回最少需要多少次操作可以使 num 变成特殊数字。
     *
     * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
     * @param num
     * @return
     */
    public int minimumOperations(String num) {
        if(Objects.equals(num, "0")){
            return 0;
        }
        int res = 0;
        char[] charArray = num.toCharArray();
        int len = charArray.length;
        int result = len;
        for(int i = len -1;i >= 0;i--){
            if(charArray[i] == '0'){
                int res1 = res;
                for(int j = i -1;j >= 0;j--){
                    if(charArray[j] == '0' || charArray[j] == '5'){
                        result = Math.min(res1,result);
                        break;
                    }else {
                        res1++;
                    }
                    if(j == 0){
                        result = Math.min(res1,result);
                    }
                }
            }
            if(charArray[i] == '5'){
                int res2 = res;
                for(int j = i -1;j >= 0;j--){
                    if(charArray[j] == '2' || charArray[j] == '7'){
                        result = Math.min(res2,result);
                        break;
                    }else {
                        res2++;
                    }
                    if(j == 0){
                        result = Math.min(res2+1,result);
                    }
                }
            }
            res++;
        }
        result = Math.min(result,res);
        return result;
    }

    @Test
    public void test(){
        minimumOperations("2908305");
    }
}
