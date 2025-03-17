/**
 * @author 孙铃
 * @date 2025/3/17 13:17
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3019
 * @Date：2025/3/17
 * @Filename：problem_3019
 */
public class problem_3019 {
    /**
     * 3019. 按键变更的次数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。例如 s = "ab" 表示按键变更一次，
     * 而 s = "bBBb" 不存在按键变更。
     *
     * 返回用户输入过程中按键变更的次数。
     *
     * 注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
     * @param s
     * @return
     */
    public int countKeyChanges(String s) {
        String lowerCase = s.toLowerCase();
        char[] charArray = lowerCase.toCharArray();
        int res = 0;
        char last = charArray[0];
        for(char c : charArray) {
            if(last != c) {
                res++;
            }
            last = c;
        }
        return res;
    }
}
