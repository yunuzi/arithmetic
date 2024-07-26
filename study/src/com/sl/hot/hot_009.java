package com.sl.hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_009
 * @Date：2024-3-14 9:09
 * @Filename：hot_009
 */
public class hot_009 {
    /**
     * 438. 找到字符串中所有字母异位词
     * 中等
     * 相关标签
     * 相关企业
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        int arr[] = new int[130];
        for(int i = 0;i < p.length();i++){
            arr[p.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(arr[s.charAt(right)] > 0){
                arr[s.charAt(right++)]--;
                if(right - left == p.length()){
                    list.add(left);
                }
            }else {
                arr[s.charAt(left++)]++;
            }
        }
        return list;
    }


    @Test
    public void test(){
        findAnagrams("aa","bb");
    }
}
