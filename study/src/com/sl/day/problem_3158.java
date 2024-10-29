/**
 * @author 孙铃
 * @date 2024/10/12 14:15
 */
package com.sl.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sl
 * @date 2024/10/12 14:15
 */
public class problem_3158 {

    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                ans ^= entry.getKey();
            }
        }

        return ans;
    }
}
