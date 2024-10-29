package com.sl.arithmeticTrain;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2438
 * @Date：2024-7-19 9:35
 * @Filename：problem_2438
 */
public class problem_2438 {
    /**
     * 我写的有问题，前缀乘积太大了
     *
     *
     * 2438. 二的幂数组中查询范围内的乘积
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
     *
     * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
     *
     * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个 answers[i] 都对 109 + 7 取余 。
     * @param n
     * @param queries
     * @return
     */
    public int[] productQueries(int n, int[][] queries) {
        int arr[] = new int[32];
        int m = n;
        int k = 0;
        while(m != 0){
            if(m == 1){
                arr[k++] = 0;
                m = 0;
            }else {
                int temp = dep(m);
                arr[k++] = temp;
                m -= (int) Math.pow(2,temp);
            }
        }
        long [] powers = new long[k];
        powers[0] = arr[k - 1];
        for(int i = 1; i < k; i++){
            powers[i] = (powers[i - 1] + arr[k - i - 1]);
        }
        int [] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
//            ans[i] = (int)( (powers[queries[i][1]] / (queries[i][0] - 1 >= 0 ? powers[queries[i][0] - 1] : 1) ) % 1000000007);
            ans[i] = (int) ( Math.pow(2,powers[queries[i][1]] - (queries[i][0] - 1 >= 0 ? powers[queries[i][0] - 1] : 0)) % 1000000007);
        }
        return ans;
    }
    public int dep(int n){
        int dep = 1;
        int x = 0;
        while(dep <= n){
            dep = dep << 1;
            x++;
        }
        return x - 1;
    }

    @Test
    public void test(){
        productQueries(2, new int[][]{{0,0}});
    }














//    class Solution:
//    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
//    s = [0]
//            for i in range(32):
//            if n & (1 << i):
//            s.append(s[-1] + i)
//    ans = []
//    mod = 10 ** 9 + 7
//            for l, r in queries:
//            ans.append(pow(2, (s[r+1] - s[l]), mod))
//            return ans
}
