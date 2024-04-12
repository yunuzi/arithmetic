package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_73
 * @Date：2024-4-9 9:17
 * @Filename：problem_73
 */
public class problem_73 {
    /**
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        Boolean Zero = false;
        for(int i =0;i < row;i++){
            if(matrix[i][0] == 0){
                Zero = true;
            }
            for(int j = 1;j < col;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for( int i = row - 1;i >= 0;i--) {
            for(int j = 1;j < col;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(Zero) {
                matrix[i][0] = 0;
            }
        }
    }
}
