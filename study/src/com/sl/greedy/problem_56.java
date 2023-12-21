package com.sl.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：problem_56
 * @Date：2023-12-21 19:44
 * @Filename：problem_56
 */
public class problem_56 {

    /**
     * 56. 合并区间
     * 中等
     * 相关标签
     * 相关企业
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //添加元素的左边
        int right = 0;
        //添加元素的右边
        int left = 0;

        List<int []> res = new ArrayList<>();
        //新数组的长度
        int index = 0;
        for(int i = 0;i < intervals.length;i++){
            left = intervals[i][0];
            right = intervals[i][1];
            while( i <intervals.length - 1 && right >= intervals[i + 1][0]){//当添加元素的右边界大于等于遍历到的元素的左边界
                right = Math.max(right,intervals[++i][1]);  //更新右边界
            }
            res.add(new int[]{left, right});
            index++;
        }

        return res.toArray(new int[index][]);
    }
}
