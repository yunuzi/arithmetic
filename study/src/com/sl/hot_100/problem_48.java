/**
 * @author 孙铃
 * @date 2024/4/18 21:48
 */
package com.sl.hot_100;

/**
 * @author 铃
 * @date 2024/4/18 21:48
 */
public class problem_48 {
    /**
     * 48. 旋转图像
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int num = 0;
        for (int i = n -1;i >= 0;i--){
            for (int j = 0;j < n;j++){
                num++;
                matrix[j][i] = num;
            }
        }
    }
}
