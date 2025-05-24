/**
 * @author 孙铃
 * @date 2025/5/12 13:23
 */
package com.sl.dp;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_91
 * @Date：2025/5/12
 * @Filename：problem_91
 */
public class problem_91 {
    /**
     * 91. 解码方法
     * 中等
     * 相关标签
     * 相关企业
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     *
     * "1" -> 'A'
     *
     * "2" -> 'B'
     *
     * ...
     *
     * "25" -> 'Y'
     *
     * "26" -> 'Z'
     *
     * 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
     *
     * 例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1, 1, 10, 6)
     * "KJF" ，将消息分组为 (11, 10, 6)
     * 消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
     * 注意，可能存在无法解码的字符串。
     *
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。
     *
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || (len == 1 && s.charAt(0) == '0')) return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 0; i < len;i++){
            int temp = 0;
            if(s.charAt(i) != '0') temp = dp[1];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')))
                temp += dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }

        return dp[1];
    }

    @Test
    public void test() {
        System.out.println(numDecodings("2611055971756562"));
    }
}
