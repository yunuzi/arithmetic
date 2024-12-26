/**
 * @author 孙铃
 * @date 2024/12/26 11:08
 */
package com.sl.random;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_2787
 * @Date：2024/12/26
 * @Filename：problem_2787
 */
public class problem_2787 {

    /**
     * 2787. 将一个数字表示成幂的和的方案数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个 正 整数 n 和 x 。
     *
     * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1x + n2x + ... + nkx 。
     *
     * 由于答案可能非常大，请你将它对 109 + 7 取余后返回。
     *
     * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 23 + 33 + 53
     * @param n
     * @param x
     * @return
     */
    private static final int MOD = 1000000007;
    public int numberOfWays(int n, int x) {
        // 计算所有小于等于 n 的正整数的 x 次幂
        List<Integer> powers = new ArrayList<>();
        int i = 1;
        while (Math.pow(i, x) <= n) {
            powers.add((int) Math.pow(i, x));
            i++;
        }

        // 初始化 dp 数组，dp[i] 表示将数字 i 表示成一些互不相同正整数的 x 次幂之和的方案数
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0 可以表示成空集的和

        // 动态规划填充 dp 数组
        for (int power : powers) {
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % MOD;
            }
        }

        return dp[n];
    }
}
