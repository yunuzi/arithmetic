/**
 * @author 孙铃
 * @date 2024/10/23 11:20
 */
package com.sl.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_2945
 * @Date：2024/10/23
 * @Filename：problem_2945
 */
public class problem_2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        CharSequence cs = String.valueOf(x);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length;i++) {
            if(words[i].contains(cs)){
                res.add(i);
            }
        }
        return res;
    }
}
