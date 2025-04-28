/**
 * @author 孙铃
 * @date 2025/4/22 10:31
 */
package com.sl.dp;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_72
 * @Date：2025/4/22
 * @Filename：problem_72
 */
public class problem_72 {
    /**
     * 72. 编辑距离
     * 中等?
     * 相关标签
     * 相关企业
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @param word1
     * @param word2
     * @return
     */
    private char[] s, t;
    private int[][] memo;

    public int minDistance(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length;
        int m = t.length;
        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示还没有计算过
        }
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (memo[i][j] != -1) { // 之前算过了
            return memo[i][j];
        }
        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1);
        }
        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
    }
}
