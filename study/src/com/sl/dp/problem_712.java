/**
 * @author 孙铃
 * @date 2025/4/22 10:45
 */
package com.sl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_712
 * @Date：2025/4/22
 * @Filename：problem_712
 */
public class problem_712 {
    /**
     * 712. 两个字符串的最小ASCII删除和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
     * @param s1
     * @param s2
     * @return
     *
     *
     * 提示:
     *
     * 0 <= s1.length, s2.length <= 1000
     * s1 和 s2 由小写英文字母组成
     */

    private char[] s, t;
    private int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        s = s1.toCharArray();
        t = s2.toCharArray();
        dp = new int[s.length + 1][t.length + 1];

        //初始化
        for(int i = 1; i<= s1.length();i++) {
            dp[i][0] = dp[i -1][0] + s[i -1];
        }
        for(int j = 1; j <= t.length; j++){
            dp[0][j] = dp[0][j -1] + t[j -1];
        }

        for(int i = 1;i <= s1.length();i++) {
            for(int j = 1;j <= t.length;j++) {
                //如果相等
                if(s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i -1][j] + s[i -1],dp[i][j -1] + t[j -1]);
                }
            }
        }
        return dp[s.length][t.length];
    }



    @Test
    public void test() {
        System.out.println(minimumDeleteSum("bac", "bc"));
    }
}
