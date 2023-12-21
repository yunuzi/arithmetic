package com.sl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.weak_01
 * @Project：study
 * @name：day_09
 * @Date：2023-12-8 14:27
 * @Filename：day_09
 */
public class day_09  {

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
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        String str ="";
        for(int i = 0;i < n;i++){
            str += ".";
        }
        backTracking(str,n,0);
        return res;
    }

    private void backTracking(String str, int n, int startIndex) {
        if(path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i < n;i++){

        }

    }
}
