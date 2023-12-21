package com.sl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class day_02 {

    /**
     * 131. 分割回文串
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     */

    public List<List<String>> res = new ArrayList<>();
    public List<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {

        backTracking(s,0);
        return res;
    }


    //回溯函数
    public void backTracking(String s, int startIndex){

        if(startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i < s.length();i++){
            if(palSubstring(s.substring(startIndex,i + 1))){
                path.add(s.substring(startIndex,i + 1));
            }else {
                continue;
            }
            //进行循环
            backTracking(s,i + 1);
            //进行回溯
            path.remove(path.size() - 1);
        }


    }

    //判断字符串是不是回文串
    private boolean palSubstring(String substring) {
        String x = new StringBuilder(substring).reverse().toString();
      if(substring.equals(x)){
          return true;
      }
       return false;
    }

    @Test
    public void test(){
        partition("aab");
    }


}
