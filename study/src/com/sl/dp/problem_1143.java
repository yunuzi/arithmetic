/**
 * @author 孙铃
 * @date 2025/4/29 13:31
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1143
 * @Date：2025/4/29
 * @Filename：problem_1143
 */
public class problem_1143 {
    /**
     * 1143. 最长公共子序列
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
     * （也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * @param text1
     * @param text2
     * @return
     *
     * 示例 1：
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *
     * 提示：
     *
     * 1 <= text1.length, text2.length <= 1000
     * text1 和 text2 仅由小写英文字符组成。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //定义dp[i][j] 表示text1[0,i-1] 和 text2[0,j-1] 的最长公共子序列长度
        //当i 为 0 时，dp[i][j] = 0 或者 j 为 0 时，dp[i][j] = 0
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        //初始化数组
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
