/**
 * @author 孙铃
 * @date 2024/10/12 14:27
 */
package com.sl.day;

/**
 * @author sl
 * @date 2024/10/12 14:27
 */
public class problem_983 {

    /**
     * 983. 最低票价
     * 中等
     * 相关标签
     * 相关企业
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
     *
     * 火车票有 三种不同的销售方式 ：
     *
     * 一张 为期一天 的通行证售价为 costs[0] 美元；
     * 一张 为期七天 的通行证售价为 costs[1] 美元；
     * 一张 为期三十天 的通行证售价为 costs[2] 美元。
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     *
     * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] isTravel = new boolean[lastDay + 1];
        for (int d : days) {
            isTravel[d] = true;
        }
        int[] memo = new int[lastDay + 1];
        return dfs(lastDay, isTravel, costs, memo);
    }



    private int dfs(int i, boolean[] isTravel, int[] costs, int[] memo) {
        if (i <= 0) {
            return 0;
        }
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        if (!isTravel[i]) {//当天没有行程的直接跳过
            return memo[i] = dfs(i - 1, isTravel, costs, memo);
        }
        return memo[i] = Math.min(dfs(i - 1, isTravel, costs, memo) + costs[0],
                Math.min(dfs(i - 7, isTravel, costs, memo) + costs[1],
                        dfs(i - 30, isTravel, costs, memo) + costs[2]));
    }

}
