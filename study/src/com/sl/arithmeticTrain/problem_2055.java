package com.sl.arithmeticTrain;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2055
 * @Date：2024-7-22 14:23
 * @Filename：problem_2055
 */
public class problem_2055 {

    /**
     * 2055. 蜡烛之间的盘子
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
     *
     * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
     *
     * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
     * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int temp = 0;
        int start = 0;
        int flag = 0;
        int temp1 = 0;
        int [][] arr = new int[len + 1][2];
        arr[0][0]= 0;
        arr[0][1] = 0;
        for(int i= 0;i<len;){
            if(charArray[i] == '|' && flag == 0){
                arr[i][0] = 0;
                arr[i][1] = 0;
                start = i;
                flag = 1;
                i++;
                continue;
            }
            while(i < len &&charArray[i] == '*' && flag == 1){
                arr[i][0] = 0;
                arr[i][1] = 0;
                temp++;
                temp1++;
                i++;
            }
            while(i < len && charArray[i] == '*' && flag == 0){
                arr[i][0] = 0;
                arr[i++][1] = 0;
            }
            while(i< len && charArray[i] == '|' && flag == 1){
                for(int j = start + 1;j<=i;j++){
                        arr[j][1] = temp;
                        arr[j][0] = temp - temp1;
                }
                temp1 = 0;
                start = i;
                i++;
            }
        }
        for(int i = start + 1;i < len+1;i++){
            arr[i][0] = arr[i-1][1];
            arr[i][1] = arr[i-1][1];
        }
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
//            result[i] = arr[queries[i][0]
            int x = queries[i][0];
            int y = queries[i][1];
            int s1 = 0;
            int s2 = 0;
            s1 = arr[x][1];
            if(charArray[y] == '|'){
                s2 = arr[y][1];
            }
            if(charArray[y] == '*'){
                s2 = arr[y][0];
            }
            result[i] = Math.max(s2 - s1, 0);
        }
        return result;
    }

    @Test
    public void test(){
        platesBetweenCandles("*|*||||**|||||||*||*||*||**|*|*||*",new int[][]{{2,33}});
    }
}
