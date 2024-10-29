package com.sl.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2961
 * @Date：2024-7-30 10:24
 * @Filename：problem_2961
 */
public class problem_2961 {
    /**
     *2961. 双模幂运算
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
     *
     * 如果满足以下公式，则下标 i 是 好下标：
     *
     * 0 <= i < variables.length
     * ((aibi % 10)ci) % mi == target
     * 返回一个由 好下标 组成的数组，顺序不限 。
     * @param variables
     * @param target
     * @return
     */
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (pow(pow(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    // 本题 mod 很小，即使平方也不会超过 int 范围，所以不需要用 long
    private int pow(int x, int n, int mod) {//快速幂和惩罚的模运算
        int res = 1;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return res;
    }
}
