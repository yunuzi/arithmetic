/**
 * @author 孙铃
 * @date 2024/11/1 15:19
 */
package com.sl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_805
 * @Date：2024/11/1
 * @Filename：problem_805
 */
public class problem_805 {
    /**
     * 805. 数组的均值分割
     * 困难
     * 相关标签
     * 相关企业
     * 给定你一个整数数组 nums
     *
     * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
     *
     * 如果可以完成则返回true ， 否则返回 false  。
     *
     * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。
     * @param nums
     * @return
     */
    private int[] num;
    private int[][] memo;
    public boolean splitArraySameAverage(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int x : nums) {
            sum += x;
        }
//        if(sum % len != 0) {
//            return false;
//        }

        //每个数组分到的平均数为
        double target = (double) sum / len;
        //背包问题
        this.num = nums;
        int res = 0;

        for(int i = 1; i <= len - 1; i++) {
            //判断target * i 是否为整数
            if(target * i % 1 != 0) {
                continue;
            }
            this.memo = new int[len][(int) ((target * i) + 1)];
            for(int row[] : memo) {
                Arrays.fill(row, -1);
            }
            res += dfs(len -1, (int) (target * i));
            if(res > 0) {
                return true;
            }
        }
        return res > 0;
    }

    private int dfs(int n, int m) {
        if(n < 0) {
            return m == 0 ? 1 : 0;
        }
        if(memo[n][m] != -1) {
            return memo[n][m];
        }

        if(m < num[n]) {//不选
            return memo[n][m] = dfs(n - 1, m);
        }
        //选 + 不选
        return memo[n][m] = dfs(n - 1, m) + dfs(n - 1, m - num[n]);
    }

    @Test
    public void test () {
        System.out.println(splitArraySameAverage(new int[]{18,10,5,3}));
    }

}
