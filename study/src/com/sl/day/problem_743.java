package com.sl.day;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_743
 * @Date：2024-3-26 15:52
 * @Filename：problem_743
 */
public class problem_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [][] graph = new int[n][n];
        int max = Integer.MAX_VALUE / 2;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++) {
                graph[i][j] = max;
            }
        }

        for(int i = 0;i < times.length;i++){
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

        int maxDis = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, max);
        dis[k - 1] = 0;
        boolean[] visited = new boolean[n];
        while(true){
            int x =- 1;
            //得到已经确定走到的值的节点
            for(int i = 0;i < n;i++){
                if(!visited[i] && (x < 0 || dis[x] > dis[i])){
                    x = i;
                }
            }

            if(x < 0){
                return maxDis;
            }

            if(dis[x] == max){
                return -1;
            }
            maxDis = Math.max(maxDis, dis[x]);
            visited[x] = true;
            for(int y = 0;y < n;y++){
                dis[y] = Math.min(dis[y], dis[x] + graph[x][y]);
            }
        }
    }

}
