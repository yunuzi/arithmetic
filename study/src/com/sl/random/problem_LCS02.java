/**
 * @author 孙铃
 * @date 2024/10/29 16:06
 */
package com.sl.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_LCS02
 * @Date：2024/10/29
 * @Filename：problem_LCS02
 */
public class problem_LCS02 {
    public int halfQuestions(int[] questions) {
        Map<Integer,Integer> map = new HashMap<>();
        int num = questions.length / 2;
        for(int i = 0;i<questions.length;i++){
            map.put(questions[i],map.getOrDefault(questions[i],0) + 1);
        }
        int len = map.size();
        int[] array = new int[len];
        //遍历map
        int k = 0;
        for(int i : map.keySet()){
            array[k] = map.get(i);
            k++;
        }

        Arrays.sort(array);

        int res = 0;
        for(int i = len -1;i >= 0;i--){
            num -= array[i];
            res++;
            if(num <= 0) return res;
        }

        return res;
    }
}
