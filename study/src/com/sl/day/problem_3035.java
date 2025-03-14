/**
 * @author 孙铃
 * @date 2025/3/12 9:26
 */
package com.sl.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3035
 * @Date：2025/3/12
 * @Filename：problem_3035
 */
public class problem_3035 {
    /**
     * 3305. 元音辅音字符串计数 I
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 word 和一个 非负 整数 k。
     *
     * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，
     * 并且 恰好 包含 k 个辅音字母的子字符串的总数。
     *
     * 5 <= word.length <= 250
     * word 仅由小写英文字母组成。
     * 0 <= k <= word.length - 5
     * @param word
     * @param m
     * @return
     */
     public long count(String word, int m) {
         Set<Character> vowels = new HashSet<>();
         vowels.add('a');
         vowels.add('e');
         vowels.add('i');
         vowels.add('o');
         vowels.add('u');
         int n = word.length(), consonants = 0;
         long res = 0;
         Map<Character, Integer> occur = new HashMap<>();
         int j = 0;
         for (int i = 0; i < n; i++) {
             while (j < n && (consonants < m || occur.size() < 5)) {
                 char ch = word.charAt(j);
                 if (vowels.contains(ch)) {
                     occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                 } else {
                     consonants++;
                 }
                 j++;
             }
             if (consonants >= m && occur.size() == 5) {
                 res += n - j + 1;
             }
             char left = word.charAt(i);
             if (vowels.contains(left)) {
                 occur.put(left, occur.get(left) - 1);
                 if (occur.get(left) == 0) {
                     occur.remove(left);
                 }
             } else {
                 consonants--;
             }
         }
         return res;
     }

     public long countOfSubstrings(String word, int k) {
         return count(word, k) - count(word, k + 1);
     }
}
