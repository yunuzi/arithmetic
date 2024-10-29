/**
 * @author 孙铃
 * @date 2024/5/23 22:33
 */
package com.sl.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 铃
 * @date 2024/5/23 22:33
 */
public class day03 {
    public char findTheDifference(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : charArray2) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return c;
            }
            if(map.containsValue(-1)){
                return c;
            }
        }

        return ' ';
    }


    public int longestEqualSubarray(List<Integer> nums, int k) {
        int max = 0;
        Map<Integer,int []> map = new HashMap<>();
        for(int i = 0;i < nums.size();i++){
            if(map.containsKey(nums.get(i))){
                // 0 存储位置，1存储差值，2存储个数
                int[] temp = map.get(nums.get(i));
                temp[1] =temp[1] + i - temp[0] -1;
                temp[0] = i;
                temp[2]++;
                if(temp[1] <= k){
                    max = Math.max(temp[2], max);
                }
            }else {
                map.put(nums.get(i),new int[]{i,0,1});
                max = Math.max(max,1);
            }
        }
        return max;
    }

    @Test
    public void test(){
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(1);
        nums.add(1);
        System.out.println(longestEqualSubarray(nums,2));
    }















}
