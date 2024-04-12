package com.sl.day;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2580
 * @Date：2024-3-27 9:18
 * @Filename：problem_2580
 */
public class problem_2580 {
    /**
     * 2580. 统计将重叠区间合并成组的方案数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
     *
     * 你需要将 ranges 分成 两个 组（可以为空），满足：
     *
     * 每个区间只属于一个组。
     * 两个有 交集 的区间必须在 同一个 组内。
     * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
     *
     * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
     * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 109 + 7 取余 后返回。
     */
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int mod = 1000000007;
        int x = ranges[0][0];
        int y = ranges[0][1];
        int res = 2;
        for(int i = 1; i < ranges.length; i++){
            if(ranges[i][0] <= y){
                y = Math.max(y, ranges[i][1]);
            }else{
                x = ranges[i][0];
                y = ranges[i][1];
                if(res > mod){
                    res = res % mod;
                }
                res *= 2;
            }
        }
        return res;
    }
}
