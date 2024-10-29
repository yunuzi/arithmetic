package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：promble_3128
 * @Date：2024-8-2 16:49
 * @Filename：promble_3128
 */
public class promble_3128 {
    /**
     * 3128. 直角三角形
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个二维 boolean 矩阵 grid 。
     *
     * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
     *
     * 注意：
     *
     * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
     * @param grid
     * @return
     */
    public long numberOfRightTriangles(int[][] grid) {
        int lenX = grid.length;
        int lenY = grid[0].length;
        int[] left = new int[lenY];//列上1的个数
        int[] up = new int[lenX];//行上1的个数
        //初始化
        for(int i = 0; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                if(grid[i][j] == 1){
                    left[j]++;
                    up[i]++;
                }
            }
        }
        long res = 0;
        for(int i = 0;i < lenX;i++){
            for(int j = 0;j < lenY;j++){
                if(grid[i][j] == 1){
                    int line = left[j] - 1;
                    int row = up[i] - 1;
                    res += (long) line * row;
                }
            }
        }
    return res;
    }
}
