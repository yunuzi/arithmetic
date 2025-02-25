/**
 * @author 孙铃
 * @date 2025/2/24 10:53
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1170
 * @Date：2025/2/24
 * @Filename：problem_1170
 */
public class problem_1170 {
    /**
     * 1170. 比较字符串最小字母出现频次
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
     *
     * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
     *
     * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
     *
     * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int [] arr1 = new int[queries.length];
        int [] arr2 = new int[words.length];
        for(int i = 0; i < queries.length; i++) {
            arr1[i] = minLen(queries[i]);
        }
        for(int i = 0; i < words.length; i++) {
            arr2[i] = minLen(words[i]);
        }
        //对arr2进行排序
        Arrays.sort(arr2);
        for(int i = 0; i < arr1.length; i++) {
            for(int j = arr2.length - 1; j >= 0; j--) {
                if(arr1[i] < arr2[j]) {
                    ans[i]++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }

    public int minLen(String str) {
        if(str.length() == 1) {
            return 1;
        }
        char[] charArray = str.toCharArray();
        int len = 1;
        char minChar = charArray[0];
        for(int i = 1;i < charArray.length;i++) {
            if(charArray[i] < minChar) {
                minChar = charArray[i];
                len = 1;
                continue;
            }
            if(charArray[i] == minChar) {
                len++;
            }
        }
    return len;
    }

//更快
//    public int[] numSmallerByFrequency(String[] queries, String[] words) {
//        int[] number = new int[12];
//        int[] ans = new int[queries.length];
//
//        for (String word : words) {
//            number[count(word)]++;
//        }
//        for (int i = 9; i >= 1; i--) {
//            number[i] += number[i + 1];
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            ans[i] = number[count(queries[i]) + 1];
//        }
//        return ans;
//    }
//
//    private int count(String str) {
//        char ch = 'z';
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char temp = str.charAt(i);
//            if (temp < ch) {
//                ch = temp;
//                sum = 1;
//            } else if (temp == ch) {
//                sum++;
//            }
//        }
//        return sum;
//    }

    @Test
    public void test() {//1
        int[] ints = numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"});
        System.out.println(Arrays.toString(ints));
    }
}
