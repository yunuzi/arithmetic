/**
 * @author 孙铃
 * @date 2025/3/7 15:00
 */
package com.sl.day;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1705
 * @Date：2025/3/7
 * @Filename：problem_1705
 */
public class problem_1705 {
    /**
     * 1705. 吃苹果的最大数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
     *
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     *
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        //n天  有苹果就吃
        int n = apples.length;
        int res = 0;
        //优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n || !pq.isEmpty(); i++) {
            if (i < n && apples[i] > 0) {
                pq.offer(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] <= 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[1]--;
                res++;
                if (cur[1] > 0) {
                    pq.offer(cur);
                }
            }
        }

        return res;
    }
}
