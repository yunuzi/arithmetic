package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_343
 * @Date：2023-12-22 16:04
 * @Filename：problem_343
 */
public class problem_343 {

    /**
     343. 整数拆分
     中等
     相关标签
     相关企业
     提示
     给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

     返回 你可以获得的最大乘积 。
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int [] dp = new int[n + 1];
        //初始化dp数组
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        int res = 1;
        //根据dp公式走到dp[n]
        for(int i = 3;  i < dp.length;i++){
            for(int j = 1; j < i;j++){
                dp[i] = Math.max(dp[i],(Math.max(j*(i - j),j*dp[i-j])));
            }


        }
        return dp[n];
    }

}
