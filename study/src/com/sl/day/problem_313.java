/**
 * @author 孙铃
 * @date 2025/5/26 16:32
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_313
 * @Date：2025/5/26
 * @Filename：problem_313
 */
public class problem_313 {
    /**
     * 313. 超级丑数
     * 中等
     * 相关标签
     * 相关企业
     * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
     *
     * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
     *
     * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
     * @param n
     * @param primes
     * @return
     *
     * 提示：
     *
     * 1 <= n <= 10^5
     * 1 <= primes.length <= 100
     * 2 <= primes[i] <= 1000
     * 题目数据 保证 primes[i] 是一个质数
     * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        //从小到大的
        int len = primes.length;
        int [] cloum_n = new int[len];
        Arrays.fill(cloum_n, 0);
        int [] res_n = new int[n];
        Arrays.fill(res_n, 1);
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i < n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < len;j++){
                res_n[j] = dp[cloum_n[j]] * primes[j];
                if(res_n[j] > 0) {
                    min = Math.min(min, res_n[j]);
                }
            }
            dp[i] = min;
            for(int j = 0;j < len;j++) {
                if(min == res_n[j]){
                    cloum_n[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
