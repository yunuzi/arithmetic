/**
 * @author 孙铃
 * @date 2024/11/20 16:16
 */
package com.sl.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3243
 * @Date：2024/11/20
 * @Filename：problem_3243
 */
public class problem_3243 {
    /**
     * 3243. 新增道路查询后的最短距离 I
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数 n 和一个二维整数数组 queries。
     *
     * 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
     *
     * queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
     *
     * 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度
     * @param n
     * @param queries
     * @return
     */

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n - 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            g[i].add(i + 1);
        }

        int[] ans = new int[queries.length];
        int[] vis = new int[n - 1];
        for (int i = 0; i < queries.length; i++) {
            g[queries[i][0]].add(queries[i][1]);
            ans[i] = bfs(i + 1, g, vis, n);
        }
        return ans;
    }

    private int bfs(int i, List<Integer>[] g, int[] vis, int n) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        for (int step = 1; ; step++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int x : tmp) {
                for (int y : g[x]) {
                    if (y == n - 1) {
                        return step;
                    }
                    if (vis[y] != i) {
                        vis[y] = i;
                        q.add(y);
                    }
                }
            }
        }
    }


    //dp
  public int[] shortestDistanceAfterQueries2(int n, int[][] queries) {
      List<Integer>[] from = new ArrayList[n];
      Arrays.setAll(from, i -> new ArrayList<>());
      int[] f = new int[n];
      for (int i = 1; i < n; i++) {
          f[i] = i;
      }

      int[] ans = new int[queries.length];
      for (int qi = 0; qi < queries.length; qi++) {
          int l = queries[qi][0];
          int r = queries[qi][1];
          from[r].add(l);
          if (f[l] + 1 < f[r]) {
              f[r] = f[l] + 1;
              for (int i = r + 1; i < n; i++) {
                  f[i] = Math.min(f[i], f[i - 1] + 1);
                  for (int j : from[i]) {
                      f[i] = Math.min(f[i], f[j] + 1);
                  }
              }
          }
          ans[qi] = f[n - 1];
      }
      return ans;
  }

    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            int[] nxt = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                nxt[i] = i + 1;
            }

            int[] ans = new int[queries.length];
            int cnt = n - 1;
            for (int qi = 0; qi < queries.length; qi++) {
                int l = queries[qi][0];
                int r = queries[qi][1];
                if (nxt[l] > 0 && nxt[l] < r) {
                    for (int i = nxt[l]; i < r;) {
                        cnt--;
                        int tmp = nxt[i];
                        nxt[i] = 0;
                        i = tmp;
                    }
                    nxt[l] = r;
                }
                ans[qi] = cnt;
            }
            return ans;
        }
    }

}
