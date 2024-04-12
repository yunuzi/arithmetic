package com.sl.day;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3085
 * @Date：2024-3-26 17:16
 * @Filename：problem_3085
 */
public class problem_3085 {
    public int minimumDeletions(String word, int k) {
        int [] count = new int[26];
        for(int i = 0; i < word.length(); i++){
            count[word.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        int maxSave = 0;
        for(int i =0;i < 26;i++){
            int sum = 0;
            for(int j = i;j < 26;j++){
                sum += Math.min(count[j],count[i] +k);
            }
            maxSave = Math.max(maxSave,sum);
        }
        return word.length() - maxSave;
    }
}
