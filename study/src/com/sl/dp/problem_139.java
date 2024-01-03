package com.sl.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_139
 * @Date：2024-1-3 14:10
 * @Filename：problem_139
 */
public class problem_139 {

    /**
     * 139. 单词拆分
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
    Boolean [] dp = new Boolean[len + 1];
        for(int i = 0;i <= s.length();i++){
            dp[i] = false;
        }
    dp[0] = true;
    for(int j = 1;j <= len;j++){
        for(int i = 0;i < wordDict.size();i++){
            if(j >= wordDict.get(i).length() && dp[j - wordDict.get(i).length()]){
                if(s.substring(j - wordDict.get(i).length(),j).equals(wordDict.get(i))){
                    dp[j] = dp[j - wordDict.get(i).length()];
                }
            }
        }
    }
    return dp[s.length()];
    }

    @Test
    public void test(){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(  wordBreak(s,wordDict));

    }
}
