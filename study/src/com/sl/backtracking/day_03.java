package com.sl.backtracking;

import java.util.ArrayList;
import java.util.List;

public class day_03 {


    /**
     *93. 复原 IP 地址
     * 中等
     * 相关标签
     * 相关企业
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     * @param s
     * @return
     */

    public List<String> res = new ArrayList<>();
    public int path = 0;
    public List<String> restoreIpAddresses(String s) {
    StringBuilder x = new StringBuilder(s);
    backTracking(x,0);
        return res;
    }


    public void backTracking(StringBuilder s, int startIndex){
        if(path == 3){
            if(legal(s.substring(startIndex))){
                res.add(String.valueOf(s));
            }
            return;
        }
    for(int i = startIndex;i < s.length();i++){
        if(legal(s.substring(startIndex, i + 1))){
            s.insert(i + 1,'.');
            path++;
            //进行回溯
            backTracking(s,i + 2);
            path--;
           s.delete(i + 1,i + 2);
        }
       if(i - startIndex > 3){
           return;
       }
    }

    }


    public Boolean legal(String s){
        try {
            int num = Integer.parseInt(s);
            if(s.length() > 1){
                if(Integer.parseInt(String.valueOf(s.charAt(0))) == 0){
                    return false;
                }
            }
            if( num >=0 && num <= 255){
                return true;
            }else {
                return false;
            }
        } catch (NumberFormatException e) {
           return false;
        }
    }

}
