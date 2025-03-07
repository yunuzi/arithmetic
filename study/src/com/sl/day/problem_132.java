/**
 * @author 孙铃
 * @date 2025/3/4 9:51
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_132
 * @Date：2025/3/4
 * @Filename：problem_132
 */
public class problem_132 {
    /**
     * 132. 分割回文串 II
     * 困难
     * 相关标签
     * 相关企业
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回符合要求的 最少分割次数 。
     * @param s
     * @return
     */
    public int minCut(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] palMemo = new int[n][n];
        for (int[] row : palMemo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        int[] dfsMemo = new int[n];
        Arrays.fill(dfsMemo, -1); // -1 表示没有计算过
        return dfs(n - 1, s, palMemo, dfsMemo);
    }

    private int dfs(int r, char[] s, int[][] palMemo, int[] dfsMemo) {
        if (isPalindrome(0, r, s, palMemo)) { // 已是回文串，无需分割
            return 0;
        }
        if (dfsMemo[r] != -1) { // 之前计算过
            return dfsMemo[r];
        }
        int res = Integer.MAX_VALUE;
        for (int l = 1; l <= r; l++) { // 枚举分割位置
            if (isPalindrome(l, r, s, palMemo)) {
                res = Math.min(res, dfs(l - 1, s, palMemo, dfsMemo) + 1); // 在 l-1 和 l 之间切一刀
            }
        }
        return dfsMemo[r] = res; // 记忆化
    }

    private boolean isPalindrome(int l, int r, char[] s, int[][] palMemo) {
        if (l >= r) {
            return true;
        }
        if (palMemo[l][r] != -1) { // 之前计算过
            return palMemo[l][r] == 1;
        }
        boolean res = s[l] == s[r] && isPalindrome(l + 1, r - 1, s, palMemo);
        palMemo[l][r] = res ? 1 : 0; // 记忆化
        return res;
    }

    @Test
    public void test() {
        System.out.println(minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}
