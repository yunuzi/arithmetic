package com.sl.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：problem_763
 * @Date：2023-12-21 11:31
 * @Filename：problem_763
 */
public class problem_763 {
    /**
     *763. 划分字母区间
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {

        List<Integer> list = new LinkedList<>();
        int [] chars = new int[26];
        char[] charArray = s.toCharArray();
        //记录字符串中字母的最远位置
        for(int i = 0;i < charArray.length;i++){
            chars[charArray[i] - 'a'] = i;
        }
        int last = -1;
        //记录最大位置
        int curMax = 0;
        for(int i=0;i < charArray.length;i++){
            curMax = Math.max(curMax,chars[charArray[i] - 'a']);
            //若当前位置已经遍历到切割字符串中字母的最远位置，则进行切割
            if(i == curMax){
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
