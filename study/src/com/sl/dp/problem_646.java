/**
 * @author 孙铃
 * @date 2025/4/28 14:06
 */
package com.sl.dp;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_646
 * @Date：2025/4/28
 * @Filename：problem_646
 */
public class problem_646 {
    /**
     * 646. 最长数对链
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
     *
     * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
     *
     * 找出并返回能够形成的 最长数对链的长度 。
     *
     * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     * @param pairs
     * @return
     *
     * 示例 1：
     *
     * 输入：pairs = [[1,2], [2,3], [3,4]]
     * 输出：2
     * 解释：最长的数对链是 [1,2] -> [3,4] 。
     * 示例 2：
     *
     * 输入：pairs = [[1,2],[7,8],[4,5]]
     * 输出：3
     * 解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。
     *
     * 提示：
     *
     * n == pairs.length
     * 1 <= n <= 1000
     * -1000 <= lefti < righti <= 1000
     */
    public int findLongestChain(int[][] pairs) {//跟严格递增差不多
        int len = pairs.length;
        int res = 1;
        int dp[] = new int[len];
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        //根据pairs[i][0] 进行排序
        Arrays.sort(pairs,(a, b) -> a[0] - b[0]);
        for(int i = 1; i < len; i++) {
            for(int j = 0;j <i; j++) {
                if(pairs[i][0] > pairs[j][1]) {//大于则加
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
