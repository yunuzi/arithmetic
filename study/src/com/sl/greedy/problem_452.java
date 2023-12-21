package com.sl.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：problem_452
 * @Date：2023-12-21 10:11
 * @Filename：problem_452
 */
public class problem_452 {
    /**
     * 452. 用最少数量的箭引爆气球
     * 中等
     * 相关标签
     * 相关企业
     * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
     * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
     *
     * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
     * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
     *
     * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int right = 0;
        int left = 0;
        int res = points.length;
        for(int i = 0;i + 1< points.length;i++){

            left = points[i + 1][0];
            //取右边界的最小值
            right =Math.min( points[i][1],points[i + 1][1]);
            while(left <= right && i < points.length -1){
                //当右边界大于等于左边界，则需要的箭数-1
                res--;
                i++;
                if( i < points.length -1){
                    left = points[i + 1][0];
                    //更新右边界的最小值
                    right = Math.min(right, points[i + 1][1]);
                }

            }
        }

        return res;


    }

    @Test
    public void test(){
        int [][] points = {{1,2},{3,4}};
        System.out.println(findMinArrowShots(points));

    }


}
