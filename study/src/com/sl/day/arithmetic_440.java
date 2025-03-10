/**
 * @author 孙铃
 * @date 2025/3/10 9:21
 */
package com.sl.day;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：arithmetic_440
 * @Date：2025/3/10
 * @Filename：arithmetic_440
 */
public class arithmetic_440 {

    /**
     * 3477. 将水果放入篮子 II
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
     *
     * 你需要对 fruits 数组从左到右按照以下规则放置水果：
     *
     * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
     * 每个篮子只能装 一种 水果。
     * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
     * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
     * @param fruits
     * @param baskets
     * @return
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0;j < n; j++) {
                if(baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(baskets[i] != 0) {
                res++;
            }
        }
        return res;
    }

    /**
     * 3478. 选出和最大的 K 个元素
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个整数数组，nums1 和 nums2，长度均为 n，以及一个正整数 k 。
     *
     * 对从 0 到 n - 1 每个下标 i ，执行下述操作：
     *
     * 找出所有满足 nums1[j] 小于 nums1[i] 的下标 j 。
     * 从这些下标对应的 nums2[j] 中选出 至多 k 个，并 最大化 这些值的总和作为结果。
     * 返回一个长度为 n 的数组 answer ，其中 answer[i] 表示对应下标 i 的结果。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
        public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int[][] a = new int[n][3];
            for (int i = 0; i < n; i++) {
                a[i] = new int[]{nums1[i], nums2[i], i};
            }
            Arrays.sort(a, (p, q) -> p[0] - q[0]);

            long[] ans = new long[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long s = 0;
            // 分组循环模板
            for (int i = 0; i < n; ) {
                int start = i;
                int x = a[start][0];
                // 找到所有相同的 nums1[i]，这些数的答案都是一样的
                while (i < n && a[i][0] == x) {
                    ans[a[i][2]] = s;
                    i++;
                }
                // 把这些相同的 nums1[i] 对应的 nums2[i] 入堆
                for (int j = start; j < i; j++) {
                    int y = a[j][1];
                    s += y;
                    pq.offer(y);
                    if (pq.size() > k) {
                        s -= pq.poll();
                    }
                }
            }
            return ans;
        }
}
