package com.sl.greedy;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：promble_435
 * @Date：2023-12-21 11:23
 * @Filename：promble_435
 */
public class promble_435 {

    /**
     * 435. 无重叠区间
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int right = 0;
        int left = 0;
        int res =0;
        for(int i = 0;i + 1< intervals.length;i++){

            left = intervals[i + 1][0];
            //取右边界的最小值
            right =Math.min( intervals[i][1],intervals[i + 1][1]);
            while(left < right && i < intervals.length -1){
                //当右边界大于左边界，则需要删除一个
                res++;
                i++;
                if( i < intervals.length -1){
                    left = intervals[i + 1][0];
                    //更新右边界的最小值
                    right = Math.min(right, intervals[i + 1][1]);
                }

            }
        }

        return res;

    }
}
