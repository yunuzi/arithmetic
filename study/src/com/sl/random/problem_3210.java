/**
 * @author 孙铃
 * @date 2024/11/7 18:19
 */
package com.sl.random;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3210
 * @Date：2024/11/7
 * @Filename：problem_3210
 */
public class problem_3210 {
    /**
     * 3210. 找出加密后的字符串
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s 和一个整数 k。请你使用以下算法加密字符串：
     *
     * 对于字符串 s 中的每个字符 c，用字符串中 c 后面的第 k 个字符替换 c（以循环方式）。
     * 返回加密后的字符串。
     * @param s
     * @param k
     * @return
     */
    public String getEncryptedString(String s, int k) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int len  = charArray.length;
        for(int i = 0;i < len;i++) {
            sb.append(charArray[(i + k) % len]);
        }

        return sb.toString();
    }
}
