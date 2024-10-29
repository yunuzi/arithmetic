/**
 * @author 孙铃
 * @date 2024/5/12 10:31
 */
package com.sl.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 铃
 * @date 2024/5/12 10:31
 */
public class problem {
    public int findPermutationDifference(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < charArray.length; i++){
            map.put(charArray1[i], i);
        }
        for(int i = 0; i < charArray.length; i++){
            Integer i1 = map.get(charArray[i]);
            count += Math.abs(i - i1);
        }
        return count;
    }

    public int minimumChairs(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        int max = 0;
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == 'E'){
                count++;
            }
            if(charArray[i] == 'S'){
                count = Math.max(count - 1, 0);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int day = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < meetings.length; i++){
            if(i == 0){
                start = meetings[i][0];
                end = meetings[i][1];
                day = days - (end - start + 1);
            }
            if(meetings[i][0] > end){
                start = meetings[i][0];
                end = meetings[i][1];
                day = day - (end - start + 1);
            }
            if(meetings[i][0] <= end && meetings[i][1] > end){
                start = end + 1;
                end = meetings[i][1];
                day = day - (end - start + 1);
            }

        }
        return day;
    }

    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder(); // 使用StringBuilder作为虚拟栈
        for (char c : s.toCharArray()) {
            if (c != '*') {
                sb.append(c); // 遇到非'*'字符，入栈（追加到StringBuilder末尾）
            } else {
                if (sb.length() > 0) { // 如果栈非空，即存在可移除的字符
                    //删除sb中字典序最小的字符
                    char minChar = sb.charAt(sb.length() - 1);
                    int x = 0;
                    for(int i = 0; i < sb.length(); i++){
                        //找到最小的字符
                        minChar = (char) Math.min(minChar, sb.charAt(i));
                        if(minChar == sb.charAt(i)){
                            x = i;
                        }
                    }
                    sb.deleteCharAt(x);
//                    sb.deleteCharAt(sb.length() - 1); // 移除栈顶（最后一个）字符，模拟删除操作
                }
            }
        }
        return sb.toString(); // 返回处理后的字符串，已移除所有'*'字符
    }


    public int numberOfChild(int n, int k) {
        int m = k / (n - 1);
        int l = k % (n - 1);
        if(m % 2 == 0){
            return l;
        }else{
            return n - 1 - l;
        }
    }


    public int valueAfterKSeconds(int n, int k) {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = 1;
        }
        for(int i = 0;i < k; i++){
            for(int j = 1; j < n; j++){
                arr[j] = (arr[j] + arr[j - 1]) > 1000000007 ? (arr[j] + arr[j - 1]) % 1000000007 : arr[j] + arr[j - 1];
            }
        }
        return arr[n - 1];
    }


    public static ArrayList<Integer> res = new ArrayList<>();

    public int maxTotalReward(int[] rewardValues) {
        int dp[] = new int[rewardValues.length];
        Arrays.sort(rewardValues);
        for(int i = 1; i < rewardValues.length; i++){
            dp[i] = Math.max(dp[i-1],rewardValues[i]);
            for(int j = i; j < rewardValues.length; j++){
                if(dp[j - 1] < rewardValues[j]){
                    dp[j] = Math.max(dp[j - 1], dp[j - 1] + rewardValues[j]);
                }else {
                    dp[j] = Math.max(dp[j - 1],dp[j]);
                }

            }
        }
        return dp[rewardValues.length - 1];

    }

//    public int maxTotalReward(int[] rewardValues) {
//
//        Arrays.sort(rewardValues);
//        for(int i = 0; i < rewardValues.length; i++){
//            maxTotalReward1(rewardValues, i, rewardValues[i]);
//        }
//        return res.stream().max(Integer::compareTo).get();
//
//    }

    public void maxTotalReward1(int[] rewardValues, int k,int x) {
        if(k == rewardValues.length - 1){
            res.add(x);
            return;
        }
        for(int i = k +1;i < rewardValues.length; i++){
            if(rewardValues[i] > x) {
                x = x + rewardValues[i];
                maxTotalReward1(rewardValues, i, x);
                x = x - rewardValues[i];
            }else {
                maxTotalReward1(rewardValues, i, x);
            }
        }

    }




    @Test
    public void test(){
        //1,6,4,3,2
        int [] arr = new int[]{22,94,24,1,49,96,80,64,13,72,99,10,43,25,21,1,68,77,41,8,39,29,64,42,7}; // 示例输入
        System.out.println(maxTotalReward(arr)); // 输出处理后的结果197
    }






}
