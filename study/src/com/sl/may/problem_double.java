/**
 * @author 孙铃
 * @date 2024/8/3 22:24
 */
package com.sl.may;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 铃
 * @date 2024/8/3 22:24
 */
public class problem_double {

    public int winningPlayerCount(int n, int[][] pick) {
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < pick.length; i++){
            if(map.containsKey(pick[i][0])){
                int[] integers = map.get(pick[i][0]);
                integers[pick[i][1]] = integers[pick[i][1]] + 1;
                map.put(pick[i][0],integers);
            }else {
                int[] integers = new int[11];
                integers[pick[i][1]] = 1;
                map.put(pick[i][0],integers);
            }
        }
        int res = 0;
        for(int i = 0; i <= n;i++){
            if(map.containsKey(i)){
                int[] integers = map.get(i);
                int count = 0;
                for(int j = 0; j <= 10; j++){
                    count = Math.max(count,integers[j]);
                }
                if(count > i){
                    res++;
                }
            }
        }
        return res;
    }


    public int minFlips(int[][] grid) {
        //先判断行和列的回文
        int lenX = grid.length;
        int lenY = grid[0].length;
        int [] arrX = new int[lenY];
        int [] arrY = new int[lenX];
        for(int i = 0; i < lenY; i++){
            int []temp = new int[lenX];
            for(int j = 0; j < lenX; j++){
                temp[j] = grid[j][i];
            }
            arrX[i] = check(temp);
        }

        for(int i = 0; i < lenX; i++){
            int []temp = new int[lenY];
            for(int j = 0; j < lenY; j++){
                temp[j] = grid[i][j];
            }
            arrY[i] = check(temp);
        }
        int resX = 0;
        int resY = 0;
        for(int i = 0; i < lenX; i++){
            resY += arrY[i];
        }
        for(int i = 0; i < lenY; i++){
            resX += arrX[i];
        }
        return Math.min(resX,resY);
    }
    public int check(int[] arr){
        int len = arr.length;
        int res = 0;
        for(int i = 0; i < (len / 2); i++){
            if(arr[i] != arr[len - 1 - i]){
                res++;
            }
        }
        return res;
    }


//    public int minFlips2(int[][] grid) {
//
//    }



    class neighborSum {
        int[][] grid2;

        public neighborSum(int[][] grid) {
            grid2 = grid;
        }

        public int adjacentSum(int value) {
            int x = 0; int y = 0;
            for(int i = 0; i < grid2.length; i++){
                for(int j = 0; j < grid2[0].length; j++){
                    if(grid2[i][j] == value){
                        x = i;
                        y = j;
                    }
                }
            }
            int res = 0;
            if(x > 0){
                res += grid2[x - 1][y];
            }
            if(y > 0){
                res += grid2[x][y - 1];
            }
            if(x < grid2.length - 1){
                res += grid2[x + 1][y];
            }
            if(y < grid2[0].length - 1){
                res += grid2[x][y + 1];
            }
            return res;
        }

        public int diagonalSum(int value) {
            int x = 0; int y = 0;
            for(int i = 0; i < grid2.length; i++){
                for(int j = 0; j < grid2[0].length; j++){
                    if(grid2[i][j] == value){
                        x = i;
                        y = j;
                    }
                }
            }
            int res = 0;
            if(x > 0 && y > 0){
                res += grid2[x - 1][y - 1];
            }
            if(x < grid2.length - 1 && y < grid2[0].length - 1){
                res += grid2[x + 1][y + 1];
            }
            if(x > 0 && y < grid2[0].length - 1){
                res += grid2[x - 1][y + 1];
            }
            if(x < grid2.length - 1 && y > 0){
                res += grid2[x + 1][y - 1];
            }
            return res;
        }
    }


    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int res = n -1;
        int[] ans = new int[queries.length];
        int [][] rout = new int[n][n];
        int [][] dp = new int[n][n];
        for(int i = 0; i < queries.length; i++){
            rout [i][0] = i;
        }
        for(int i = 0; i< queries.length; i++){
            //标记这个有路线
            rout[queries[i][0]][queries[i][1]] = 1;
            rout[queries[i][0]][0] = -1;
            int x = queries[i][0];
            int y = queries[i][1];
            for(int m = 0; m < n; m++){
                Arrays.fill(rout[m],Integer.MAX_VALUE);
            }
            //求最小的路径
            for(int j = 1; j < n; j++){
                dp[0][j] = Math.min(dp[0][j-1] + 1, dp[0][j]);
                for(int k = 1; k <= j; k++){

                }
            }
            ans[i] = dp[0][n-1];
        }
        return ans;
    }


    @Test
    public void test(){
        System.out.println(winningPlayerCount(4, new int[][]{{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}}));
    }
}
