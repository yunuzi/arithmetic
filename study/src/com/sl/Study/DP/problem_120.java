package com.sl.Study.DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_120
 * @Date：2024-8-13 16:46
 * @Filename：problem_120
 */
public class problem_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        int j = 0;
        for(int i = 1;i < size;i++){
            for(int k = 0;k <= i;k++){
                dp[i][k] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1;i < size;i++){
            dp[i][0] = dp[i -1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i -1][i -1] + triangle.get(i).get(i);
            for(int k = 1;k < i;k++){
                dp[i][k] = Math.min(dp[i -1][k] + triangle.get(i).get(k),dp[i -1][k - 1] + triangle.get(i).get(k));
            }
        }
        int res = dp[size-1][0];
        for(int i = 0;i < size;i++){
            res = Math.min(res,dp[size-1][i]);
        }
        return res;
    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[] dp = new int[n + 1];
//        for (int i = n - 1; i >= 0; i--) {
//            process(triangle, dp, i);
//        }
//        return dp[0];
//    }

    private void process(List<List<Integer>> triangle, int[] dp, int i) {
        List<Integer> list = triangle.get(i);
        for (int j = 0; j <= i; j++) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
        }
    }

    @Test
    public void test(){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
       triangle.get(3).add(3);
        System.out.println(minimumTotal(triangle));
    }
}
