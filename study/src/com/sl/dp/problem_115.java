/**
 * @author 孙铃
 * @date 2025/4/28 10:01
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_115
 * @Date：2025/4/28
 * @Filename：problem_115
 */
public class problem_115 {
    /**
     * 115. 不同的子序列
     * 困难
     * 相关标签
     * 相关企业
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
     *
     * 测试用例保证结果在 32 位有符号整数范围内。
     * @param s
     * @param t
     * @return
     *
     * 提示：
     *
     * 1 <= s.length, t.length <= 1000
     * s 和 t 由英文字母组成
     */
    public int numDistinct(String s, String t) {
        //思路： dp[i][j] 表示s[i] 到s[j] 这个字符串中的 子序列 t出现的次数，则 s[x][x] = 0
        int m = s.length();
        int dp[][] = new int [m + 1][m + 1];
        //初始化dp数组
        for(int i = 0; i <= m; i++) {
            dp[i][i] = 0;
        }
        //动态转移方程
        //想不出来
        return 0;
    }
}
