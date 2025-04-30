/**
 * @author 孙铃
 * @date 2025/4/29 13:09
 */
package com.sl.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1964
 * @Date：2025/4/29
 * @Filename：problem_1964
 */
public class problem_1964 {
    /**
     * 1964. 找出到每个位置为止最长的有效障碍赛跑路线
     * 困难
     * 相关标签
     * 相关企业
     * 提示
     * 你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
     *
     * 对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
     *
     * 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
     * 在这条路线中，必须包含第 i 个障碍。
     * 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
     * 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
     * 返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
     * @param obstacles
     * @return
     *
     * 提示：
     *
     * n == obstacles.length
     * 1 <= n <= 10^5
     * 1 <= obstacles[i] <= 10^7
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
//        int n = obstacles.length;
//        int []dp = new int[n];
//        List<Integer> lis = new ArrayList<>();
//        //二分+动态
//        for(int i = 0;i < n;i++) {
//            int cur = obstacles[i];
//            int left = 0;
//            int right = lis.size();
//            //找到比cur大的或等于
//            while(left < right) {
//                int mid = (left + right) / 2;
//                if(lis.get(mid) <= cur) {
//                    left = mid + 1;
//                }else {
//                    right = mid;
//                }
//            }
//            dp[i] = left + 1;
//            if(left >= lis.size()) {
//                lis.add(cur);
//            }else {
//                lis.set(left,cur);
//            }
//        }
//        return dp;

        //优化解
        int n = obstacles.length;
        int[] dp = new int[n];
        dp[0] = obstacles[0];

        int len = 1, pos = 1;
        int[] ans = new int[n];
        ans[0] = 1;

        for(int i = 1; i < n; i++) {
            int x = obstacles[i];
            if(x >= dp[len-1]) {
                dp[len++] = x;
                pos = len;
            }else{
                int l = 0, r = len - 1;
                while(l <= r) {
                    int mid = l + r >> 1;
                    if(dp[mid] <= x) {
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }

                dp[l++] = x;
                pos = l;
            }

            ans[i] = pos;
        }

        return ans;
    }
}
