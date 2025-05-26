/**
 * @author 孙铃
 * @date 2025/5/24 16:05
 */
package com.sl.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2942
 * @Date：2025/5/24
 * @Filename：problem_2942
 */
public class problem_2942 {
    /**
     * 2942. 查找包含给定字符的单词
     * 已解答
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
     *
     * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
     *
     * 注意 ，返回的数组可以是 任意 顺序。
     * @param words
     * @param x
     * @return
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < words.length;i++) {
            if(words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
