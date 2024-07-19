package com.sl.arithmeticTrain;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2559
 * @Date：2024-7-8 18:00
 * @Filename：problem_2559
 */
public class problem_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int [] prefix = new int[len + 1];
        prefix[0] = 0;
        for(int i = 0;i < len;i++){
            prefix[i + 1] = prefix[i] + visible(words[i]);
        }
        int len2 = queries.length;
        int res[] = new int[len2];
        for(int i =0;i < len2;i++){
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return res;
    }

    public int visible(String str){
        int len = str.length();
        char first = str.charAt(0);
        char last = str.charAt(len -1);
        if((first == 'a' || first == 'e' ||  first == 'i' ||  first == 'o' ||  first == 'u') &&
                (last == 'a' || last == 'e' ||  last == 'i' ||  last == 'o' ||  last == 'u')){
            return 1;
        }
        return 0;
    }

    @Test
    public void test(){
        System.out.println(vowelStrings(new String[]{"aba","bcb","ece","aa","e"},new int[][]{{0,2},{1,4},{1,1}}));
    }
}
