package com.sl.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2368
 * @Date：2024-3-2 9:17
 * @Filename：problem_2368
 */
public class problem_2368 {
    /**
     * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
     *
     * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
     *
     * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
     *
     * 注意，节点 0 不 会标记为受限节点。
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    int count = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean [] isRestricted = new boolean[n];
        for(int i : restricted){
            isRestricted[i] = true;
        }
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int [] i : edges){
            //创建每个数字下一步能走的位置
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        dfs(0,-1,graph,isRestricted);
        return count;
    }

    private void dfs(int a, int b, List<Integer>[] graph, boolean[] isRestricted) {
        count++;
        for(int i: graph[a]){
            // i != b 表示i没有走过， !isRestricted[i] 表示i没有被标记为受限节点
            if(i != b && !isRestricted[i]){
                dfs(i,a,graph,isRestricted);
            }
        }
    }
}
