/**
 * @author 孙铃
 * @date 2025/4/29 13:48
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1035
 * @Date：2025/4/29
 * @Filename：problem_1035
 */
public class problem_1035 {
    /**
     * 1035. 不相交的线
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     *
     * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足：
     *
     *  nums1[i] == nums2[j]
     * 且绘制的直线不与任何其他连线（非水平线）相交。
     * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     *
     * 以这种方法绘制线条，并返回可以绘制的最大连线数。
     * @param nums1
     * @param nums2
     * @return
     *
     * 提示：
     *
     * 1 <= nums1.length, nums2.length <= 500
     * 1 <= nums1[i], nums2[j] <= 2000
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //定义dp[i][j] 表示nums1[0,i-1] 和 nums2[0,j-1] 的最大连线数
        //当i 为 0 时，dp[i][j] = 0 或者 j 为 0 时，dp[i][j] = 0
        int m = nums1.length;
        int n = nums2.length;
        int dp[][] = new int[m + 1][n + 1];

        for(int i = 1;i <=m;i++) {
            for(int j = 1;j<= n;j++) {
                //相等则连接一条线
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i -1][j -1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
