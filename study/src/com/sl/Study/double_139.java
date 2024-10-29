package com.sl.Study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.Study
 * @Project：arithmetic
 * @name：double_139
 * @Date：2024-9-14 21:59
 * @Filename：double_139
 */
public class double_139 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < height.length; i++){
            if(height[i -1] > threshold){
                res.add(i);
            }
        }
        return res;
    }

    private int[][] memo;  // 记忆化数组
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        memo = new int[rows][cols];
        for (int[] row : memo) {
            Arrays.fill(row, -1);  // 初始化为 -1 表示未计算过
        }
        int min =  dp(grid, 0, 0);
        System.out.println(min);
        return min < health;
    }


    private int dp(List<List<Integer>> grid, int i, int j) {
        // 边界条件
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size()) {
            return Integer.MAX_VALUE;  // 越界返回最大值
        }

        // 目标位置
        if (i == grid.size() - 1 && j == grid.get(0).size() - 1) {
            return grid.get(i).get(j);  // 返回目标位置的健康值
        }

        // 已经计算过
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 当前位置的健康值
        int currentHealth = grid.get(i).get(j);

        // 向四个方向递归
        int up = dp(grid, i - 1, j);
        int down = dp(grid, i + 1, j);
        int left = dp(grid, i, j - 1);
        int right = dp(grid, i, j + 1);

        // 选择消耗最小的路径
        int minHealth = Math.min(Math.min(up, down), Math.min(left, right));

        // 更新记忆化数组
        memo[i][j] = currentHealth + minHealth;

        return memo[i][j];
    }


    @Test
    public void test(){
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> list = new ArrayList<>();//0,0,1,0,1,0
        list.add(1);
        list.add(1);
        list.add(1);
//        list.add(0);
//        list.add(0);
//        list.add(0);
        grid.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(1);
//        list.add(0);
//        list.add(0);
//        list.add(0);
        grid.add(list);
        list = new ArrayList<>();
//        list.add(0);
        list.add(1);
        list.add(1);
        list.add(1);
//        list.add(0);
//        list.add(1);
        grid.add(list);
//        list = new ArrayList<>();
//        list.add(0);
//        list.add(0);
//        list.add(1);
//        list.add(0);
//        list.add(1);
//        list.add(0);
//        grid.add(list);
        findSafeWalk(grid,5);
    }
}
