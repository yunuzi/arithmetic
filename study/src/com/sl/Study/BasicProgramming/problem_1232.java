package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1232
 * @Date：2024-7-29 9:34
 * @Filename：problem_1232
 */
public class problem_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2){
            return true;
        }
        if(coordinates[0][1] - coordinates[1][1] == 0){
            for(int i = 1;i < coordinates.length;i++){
                if(coordinates[i][1] != coordinates[0][1]){
                    return false;
                }
            }
            return true;
        }
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for(int i = 2;i < coordinates.length;i++){
            int tempX = coordinates[i][0] - coordinates[i -1][0];
            int tempY = coordinates[i][1] - coordinates[i -1][1];
            if(tempY * x != tempX * y){
                return false;
            }
        }
        return true;
    }
}
