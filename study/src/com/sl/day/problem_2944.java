/**
 * @author 孙铃
 * @date 2025/4/22 10:03
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2944
 * @Date：2025/4/22
 * @Filename：problem_2944
 */
public class problem_2944 {
    /**
     * 2944. 购买水果需要的最少金币数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 下标从 0 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i + 1 个水果需要花费的金币数目。
     *
     * 水果超市有如下促销活动：
     *
     * 如果你花费 prices[i] 购买了下标为 i + 1 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。
     * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j - 1] 个金币去购买它以获得它的奖励。
     *
     * 请你返回获得所有水果所需要的 最少 金币数。
     * @param prices
     * @return
     */
    public int minimumCoins(int[] prices) {
        //
        int[] dp = new int[prices.length + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int i = 0; i < prices.length; i++) {
            int value = dp[i] + prices[i];
            for (int j = i + 1; j <= prices.length; j++) {
                //如果超出范围，跳出循环
                if (j > i + i + 2) {
                    break;
                }
                dp[j] = Math.min(dp[j], value);
            }
        }
        return dp[prices.length];

    }

    @Test
    public void test() {
        System.out.println(minimumCoins(new int[]{1, 10, 1, 1}));
    }
}
