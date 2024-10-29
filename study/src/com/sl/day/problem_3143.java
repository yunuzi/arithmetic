/**
 * @author 孙铃
 * @date 2024/8/3 19:02
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 铃
 * @date 2024/8/3 19:02
 */
public class problem_3143 {
    /**
     * 3143. 正方形中的最多点数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。
     *
     * 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。
     *
     * 请你返回 合法 正方形中可以包含的 最多 点数。
     *
     * 注意：
     *
     * 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。
     * 正方形的边长可以为零。
     * @param points
     * @param s
     * @return
     */
    public int maxPointsInsideSquare(int[][] points, String s) {
        int len = points.length;
        int [][] point = new int[len][2];
        char[] charArray = s.toCharArray();
        for(int i = 0;i < len;i++){
            point[i][0] = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            point[i][1] = charArray[i] - 'a';
        }
        Arrays.sort(point,(a, b)->a[0] - b[0]);
        int[] res = new int[40];
        int max = 0;
        int count = 0;
        int temp = point[0][0];
        for(int i = 0;i < len;i++){
            if(res[point[i][1]] != 0){//有重复
                if(temp == point[i][0]){
                    return max;
                }
                return max + count;
            }
           if(res[point[i][1]] == 0){
               if(temp != point[i][0]){
                max += count;
                count = 0;
                temp = point[i][0];
               }
               count++;
               res[point[i][1]]++;
           }
        }
        //无重复
        if(temp == point[len - 1][0]){
            return max + count;
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxPointsInsideSquare(new int[][]{{1, 1}, {2, -2}, {-2, 2}}, "abaaa"));
    }
































}
