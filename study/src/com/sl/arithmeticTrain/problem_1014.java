package com.sl.arithmeticTrain;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_1014
 * @Date：2024-7-4 20:35
 * @Filename：problem_1014
 */
public class problem_1014 {
    /**
     * 1014. 最佳观光组合
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
     *
     * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
     *
     * 返回一对观光景点能取得的最高分。
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int lne = values.length;
        int res = 0;
        int  r = values[0] - 1;
        for (int i = 1; i < lne; i++) {
            res = Math.max(res,r + values[i]);
            r = Math.max(r,values[i]);
            r--;
        }
        return res;
    }

}
