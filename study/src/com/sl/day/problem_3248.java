/**
 * @author 孙铃
 * @date 2024/11/21 10:13
 */
package com.sl.day;

import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3248
 * @Date：2024/11/21
 * @Filename：problem_3248
 */
public class problem_3248 {
    /**
     * 3248. 矩阵中的蛇
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
     *
     * 蛇从单元格 0 开始，并遵循一系列命令移动。
     *
     * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
     *
     * 返回执行 commands 后蛇所停留的最终单元格的位置。
     * @param n
     * @param commands
     * @return
     */
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0,j = 0;
        for(String command : commands){
            switch (command){
                case "UP":
                    i--;
                    break;
                case "DOWN":
                    i++;
                    break;
                case "LEFT":
                    j--;
                    break;
                case "RIGHT":
                    j++;
                    break;
            }
        }
        return i * n + j;
    }
}
