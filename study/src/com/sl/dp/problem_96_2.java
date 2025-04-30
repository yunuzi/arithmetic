/**
 * @author 孙铃
 * @date 2025/4/30 14:07
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_96_2
 * @Date：2025/4/30
 * @Filename：problem_96_2
 */
public class problem_96_2 {
    /**
     * 96. 不同的二叉搜索树
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数
     * @param n
     * @return
     */

    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        //初始化dp数组
        dp[0] = 1;
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= i;j++) {
                dp[i] += dp[j -1] * dp[i -j];
            }
        }
        return dp[n];
    }
}
