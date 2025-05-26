/**
 * @author 孙铃
 * @date 2025/5/26 16:53
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_338
 * @Date：2025/5/26
 * @Filename：problem_338
 */
public class problem_338 {
    /**
     * 338. 比特位计数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        if(n==0) {
            return dp;
        }
        for(int i = 1;i <= n;i++) {
            if(i%2==0) {
                dp[i] = dp[i/2];
            }else {
                dp[i] = dp[i/2] + 1;
            }
        }
        return dp;
    }
}
