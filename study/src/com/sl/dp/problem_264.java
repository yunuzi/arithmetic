/**
 * @author 孙铃
 * @date 2025/5/24 14:45
 */
package com.sl.dp;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_264
 * @Date：2025/5/24
 * @Filename：problem_264
 */
public class problem_264 {
    /**
     * 264. 丑数 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     *
     * 丑数 就是质因子只包含 2、3 和 5 的正整数。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
//        if(n == 1) {
//            return 1;
//        }
//
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for(int t = 1;t < n;t++) {
//            //单调递增的队列
//            PriorityQueue<Integer> queue = new PriorityQueue<>();
//            for(int i = 1;i <= t;i++){
//                if(dp[i-1]*2 > dp[t-1]){
//                    queue.offer(dp[i-1]*2);
//                }
//                if(dp[i-1]*3 > dp[t-1]){
//                    queue.offer(dp[i-1]*3);
//                }
//                if(dp[i-1]*5 > dp[t-1]){
//                    queue.offer(dp[i-1]*5);
//                }
//            }
//            dp[t] = queue.peek().intValue();
//        }
//        return dp[n -1];
        int dp[] = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1;i < n;i++){
            int temp2 = dp[p2]*2;
            int temp3 = dp[p3]*3;
            int temp5 = dp[p5]*5;
            dp[i] = Math.min(temp2,Math.min(temp3,temp5));
            if(dp[i] == temp2){
                p2++;
            }
            if(dp[i] == temp3){
                p3++;
            }
            if(dp[i] == temp5){
                p5++;
            }
        }
        return dp[n -1];
    }

    @Test
    public void test() {
        //1399680000
        System.out.println(nthUglyNumber(10));
    }
}
