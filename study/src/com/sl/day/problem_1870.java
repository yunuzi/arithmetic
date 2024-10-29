/**
 * @author 孙铃
 * @date 2024/10/14 10:21
 */
package com.sl.day;

/**
 * @author sl
 * @date 2024/10/14 10:21
 */
public class problem_1870 {
    /**
     * 1870. 准时到达的列车最小时速
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
     *
     * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
     *
     * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
     * 返回能满足你在时限前到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
     *
     * 生成的测试用例保证答案不超过 10^7 ，且 hour 的 小数点后最多存在两位数字
     * @param dist
     * @param hour
     * @return
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        long h100 = Math.round(hour * 100); // 下面不会用到任何浮点数
        long delta = h100 - (n - 1) * 100;
        if (delta <= 0) { // 无法到达终点
            return -1;
        }

        int maxDist = 0;
        long sumDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
            sumDist += d;
        }
        if (h100 <= n * 100) { // 特判
            return Math.max(maxDist, (int) ((dist[n - 1] * 100 - 1) / delta + 1));
        }

        int left = (int) ((sumDist * 100 - 1) / h100); // 也可以初始化成 0（简单写法）
        int h = (int) (h100 / (n * 100));
        int right = (maxDist - 1) / h + 1; // 也可以初始化成 maxDist（简单写法）
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, dist, h100)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int v, int[] dist, long h100) {
        int n = dist.length;
        long t = 0;
        for (int i = 0; i < n - 1; i++) {
            t += (dist[i] - 1) / v + 1;
        }
        return (t * v + dist[n - 1]) * 100 <= h100 * v;
    }

}
