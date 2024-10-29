/**
 * @author 孙铃
 * @date 2024/5/22 18:47
 */
package com.sl.may;

import java.util.*;

/**
 * @author 铃
 * @date 2024/5/22 18:47
 */
public class day02 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < matches.length;i++){
            //赢了比赛
            map.put(matches[i][0],map.getOrDefault(matches[i][0],0));
            //输了比赛
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                list1.add(entry.getKey());
            }else if(entry.getValue() == 1){
                list2.add(entry.getKey());
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        res.add(list1);
        res.add(list2);

        return res;
    }

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        char[] res = new char[len1 + len2];
        if(len1 >= len2){
            for(int i = 0,j = 0;i < len1;i++){
                if(i < len2){
                    res[j] = charArray1[i];
                    res[j + 1] = charArray2[i];
                    j = j + 2;
                }else {
                    res[j] = charArray1[i];
                    j++;
                }
            }
        }else {
            for(int i = 0,j = 0;i < len2;i++){
                if(i < len1){
                    res[j] = charArray1[i];
                    res[j + 1] = charArray2[i];
                    j = j + 2;
                }else {
                    res[j] = charArray2[i];
                    j++;
                }
            }
        }
        return new String(res);
    }


    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while(left < right){
            int mid = (right + left) / 2;
            if(letters[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return letters[right] > target ? letters[right] : letters[0];
    }




























}
