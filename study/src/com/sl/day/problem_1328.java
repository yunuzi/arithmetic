/**
 * @author 孙铃
 * @date 2025/3/5 11:25
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1328
 * @Date：2025/3/5
 * @Filename：problem_1328
 */
public class problem_1328 {
    /**
     * 1328. 破坏回文串
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，且 不是 回文串。
     *
     * 请你返回结果字符串。如果无法做到，则返回一个 空串 。
     *
     * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符严格小于 b 中的对应字符。例如，"abcc” 字典序比 "abcd" 小，
     * 因为不同的第一个位置是在第四个字符，显然 'c' 比 'd' 小。
     * @param palindrome
     * @return
     */
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }
        int n = palindrome.length();
        char[] charArray = palindrome.toCharArray();
        int m = n / 2;
        for (int i = 0;i < m;i++) {
            if(charArray[i] != 'a') {
                charArray[i] = 'a';
                return String.valueOf(charArray);
            }
        }
        charArray[n-1] = 'b';
        return String.valueOf(charArray);
    }
}
