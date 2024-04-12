package com.sl.day;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_54
 * @Date：2024-4-9 9:30
 * @Filename：problem_54
 */
public class problem_54 {
    /**
     * 54. 螺旋矩阵
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //行长
        int m = matrix.length;
        //列长
        int n = matrix[0].length;
        Boolean over [][] = new Boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                over[i][j] = false;
            }
        }
        int stepMax = m * n;
        int x = 0;
        int y = 0;
        int step = 0;
        int left = 0;
        int right = n;
        int top = 0;
        int buttom = m;
        while (step < stepMax) {
            //向右遍历
            for(;y < right;y++){
                if(!over[x][y]){
                    res.add(matrix[x][y]);
                    over[x][y] = true;
                    step++;
                }
            }
            right--;
            y--;
            x++;
            //向下遍历
            for(;x < buttom;x++){
                if(!over[x][y]){
                    res.add(matrix[x][y]);
                    over[x][y] = true;
                    step++;
                }
            }
            buttom--;
            y--;
            x--;
            //向左遍历
            for(;y >= left;y--){
                if(!over[x][y]) {
                    res.add(matrix[x][y]);
                    over[x][y] = true;
                    step++;
                }
            }
            left++;
            y++;
            x--;
            //向上遍历
            for(;x >= top;x--){
                if(!over[x][y]){
                    res.add(matrix[x][y]);
                    over[x][y] = true;
                    step++;
                }
            }
            top++;
            x++;
            x++;
            y++;
        }
        return res;
    }

    @Test
    public void test(){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(Arrays.toString(integers.toArray()));
    }
}
