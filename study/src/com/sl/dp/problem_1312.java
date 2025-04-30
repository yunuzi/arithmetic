/**
 * @author 孙铃
 * @date 2025/4/29 13:53
 */
package com.sl.dp;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1312
 * @Date：2025/4/29
 * @Filename：problem_1312
 */
public class problem_1312 {
    /**
     * 1312. 让字符串成为回文串的最少插入次数
     * 困难
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
     *
     * 请你返回让 s 成为回文串的 最少操作次数 。
     *
     * 「回文串」是正读和反读都相同的字符串。
     * @param s
     * @return
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 中所有字符都是小写字母。
     */
    public int minInsertions(String s) {
        //dp[i][j] 表示，使得s[i,j]变成回文字符串最小插入的次数
        //当i == j 时，dp[i][j] = 0 当 s[i] == s[j] dp[i][j] = dp[i +1][j-1]
        //当s[i] != s[j] 的时候，dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i = n -1;i > 0;i--) {
            for(int j = i + 1;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][n -1];
    }

    @Test
    public void test() {
        System.out.println(minInsertions("mbadm"));
    }
}
