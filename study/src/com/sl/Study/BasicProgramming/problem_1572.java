package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1572
 * @Date：2024-7-26 13:14
 * @Filename：problem_1572
 */
public class problem_1572 {
    public int diagonalSum(int[][] mat)
    {
        int sum = 0;
        for(int i = 0; i < mat.length; i++)
        {
            sum += mat[i][i];
            sum += mat[i][mat.length - 1 - i];
        }
        if(mat.length % 2 != 0)
        {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }
}
