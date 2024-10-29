/**
 * @author 孙铃
 * @date 2024/7/28 10:27
 */
package com.sl.day;

import org.junit.Test;

/**
 * @author 铃
 * @date 2024/7/28 10:27
 */
public class arithmetic_408 {

    public boolean canAliceWin(int[] nums) {
        int res = 0;
        int count = 0;
        //选两位数
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 10){
                res += nums[i];
            }
            count += nums[i];
        }
        count = count - res;
        return res > count || res < count;
    }


    public int nonSpecialCount(int l, int r) {
        int res = 0;
        for(int i = l; i <= r; i++){
            if(!check(i)){
                res++;
            }
//            if(check(i)){
//                System.out.println(i);
//            }
        }
        return res;
    }

    public boolean check(int num){
        if (num == 1) return false;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i != num) {
                    count++;
                    if (count > 2) return false;
                }
                int x = num / i;
                if (x != num && x != i) {
                    count++;
                    if (count > 2) return false;
                }
            }
        }
        return count == 2;
    }



    public int numberOfSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        int [][] dp = new int[charArray.length][charArray.length];
        dp[0][0] = charArray[0] == '0' ? 1 : 0;
        for(int i = 1; i < charArray.length; i++){
            if(charArray[i] == '0'){
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for(int i = 1; i < charArray.length; i++){

        }
        return 1;
    }

    @Test
    public void test(){
        System.out.println(nonSpecialCount(182,18677));
    }
}
