package com.sl.dp;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1049
 * @Date：2023-12-28 15:28
 * @Filename：problem_1049
 */
public class problem_1049 {
    /**
     * 1049. 最后一块石头的重量 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     *
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0;i < stones.length;i++){
            sum += stones[i];
        }
        int target = sum / 2;
        int [] dp = new int[15000 + 1];
        dp[0] = 0;
        for(int i = 0;i < stones.length;i++){
            for(int j = target;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return (sum - dp[target]) - dp[target];
    }
}
