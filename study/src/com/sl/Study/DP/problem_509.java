package com.sl.Study.DP;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_509
 * @Date：2024-8-7 13:43
 * @Filename：problem_509
 */
public class problem_509 {
    public int fib(int n) {
        if(n ==0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int [] dfs = new int[n + 1];
        dfs[0] = 0;
        dfs[1] = 1;
        for(int i = 2;i <= n;i++){
            dfs[i] = dfs[i-1] + dfs[i-2];
        }
        return dfs[n];
    }
}
