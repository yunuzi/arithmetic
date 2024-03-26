package com.sl.day;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2642
 * @Date：2024-3-26 9:07
 * @Filename：problem_2642
 */
public class problem_2642 {

    /**
     * 2642. 设计可以求最短路径的图类
     * 困难
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，
     * 其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
     *
     * 请你实现一个 Graph 类：
     *
     * Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
     * addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
     * int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
     */
    class Graph {
        private static final int INF = Integer.MAX_VALUE / 2; // 防止更新最短路时加法溢出

        private final int[][] g;

        public Graph(int n, int[][] edges) {
            g = new int[n][n]; // 邻接矩阵
            for (int[] row : g) {
                Arrays.fill(row, INF);
            }
            for (int[] e : edges) {
                addEdge(e);
            }
        }

        public void addEdge(int[] edge) {
            g[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int start, int end) {
            int n = g.length;
            int[] dis = new int[n]; // 从 start 出发，到各个点的最短路，如果不存在则为无穷大
            Arrays.fill(dis, INF);
            dis[start] = 0;
            boolean[] vis = new boolean[n];
            while (true) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && (x < 0 || dis[i] < dis[x])) {
                        x = i;
                    }
                }
                if (x < 0 || dis[x] == INF) {// 所有从 start 能到达的点都被更新了
                    return -1;
                }
                if (x == end) {// 找到终点，提前退出
                    return dis[x];
                }
                vis[x] = true; // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
                for (int y = 0; y < n; y++) {
                    dis[y] = Math.min(dis[y], dis[x] + g[x][y]); // 更新最短路长度
                }
            }
        }
    }
}
