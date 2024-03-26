package com.sl.day;

import org.junit.Test;

import java.util.Locale;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2129
 * @Date：2024-3-11 9:09
 * @Filename：problem_2129
 */
public class problem_2129 {

    /**
     * 2129. 将标题首字母大写
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
     *
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title 。
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        int left = 0;
        int len = title.length();
        title = title.toLowerCase();
        for(int i = 0; i < len; i++){
            if(title.charAt(i) == ' ' || i == len - 1){
                if((i > left && i - left > 2) || (i == len - 1 && i - left > 1) ){ // 检查当前单词长度是否大于2
                    String word = title.substring(left, i);
                    title = title.substring(0, left) + word.substring(0, 1).toUpperCase() + word.substring(1) + title.substring(i);
                    left = i + 1;
                } else {
                    left = i + 1;
                }
            }
        }
        return title;
    }

    @Test
    public void test(){
        capitalizeTitle("ZW Cl pyR uoC");
    }

}
