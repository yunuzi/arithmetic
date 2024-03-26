package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3084
 * @Date：2024-3-26 17:03
 * @Filename：problem_3084
 */
public class problem_3084 {
    /**
     * 3084. 统计以给定字符开头和结尾的子字符串总数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s 和一个字符 c 。返回在字符串 s 中并且以 c 字符开头和结尾的
     * 非空子字符串
     * 的总数。
     * @param s
     * @param c
     * @return
     */
    public long countSubstrings(String s, char c) {
        long res = 0;
        long count = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == c){
                count++;
                res += count;
            }
        }
        return res;
    }
}
