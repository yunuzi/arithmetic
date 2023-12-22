package com.sl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



/**
 * @Author：sl
 * @Package：com.sl.backtracking
 * @Project：arithmetic
 * @name：problem_51
 * @Date：2023-12-22 10:13
 * @Filename：problem_51
 */
public class problem_51 {

    /**
     * 51. N 皇后
     * 困难
     * 相关标签
     * 相关企业
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * @param n
     * @return
     */
    public List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
     char[][] chars = new char[n][n];
        for (char[] c : chars) {
            Arrays.fill(c, '.');
        }

        backTracking(chars,0,n);
        return res;

    }


    public void backTracking( char[][] map,int index,int length){
        if(index == map.length){
            res.add(new ArrayList<>(Array2List(map)));
            return;
        }

        for(int x = 0;x < length;x++){
            if(isValid(map,index,x,length)){
                map[index][x] = 'Q';
                backTracking(map,index+1,length);
                //回溯
                map[index][x] = '.';
            }
        }


    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public Boolean isValid(char[][] map,int index,int x,int n){
        // 检查列
        for (int i=0; i<n; ++i) { // 相当于剪枝
            if (map[i][x] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线（只需要检查上面就可以）
        for (int i=index-1, j=x-1; i>=0 && j>=0; i--, j--) {
            if (map[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线（只需要检查上面的就行）
        for (int i=index-1, j=x+1; i>=0 && j<=n-1; i--, j++) {
            if (map[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
