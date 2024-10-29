/**
 * @author 孙铃
 * @date 2024/8/25 10:24
 */
package com.sl.may;

import org.junit.Test;
import sun.util.resources.hr.CalendarData_hr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 铃
 * @date 2024/8/25 10:24
 */
public class problem_412 {


    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for(int i = 0;i < k;i ++){
            int min = Integer.MAX_VALUE;
            int t = 0;
            for(int j = 0;j < n;j ++){
                if(nums[j] < min){
                    min = nums[j];
                    t = j;
                }
            }
            nums[t] = nums[t] * multiplier;
        }
        return nums;
    }



    public int countPairs(int[] nums) {
        int n = nums.length;
        int res = 0;
        int strp = 1;
        Arrays.sort(nums);
        for(int i = n -1;i >= 0;i--){
            String s = String.valueOf(nums[i]);
            int len = s.length();
            char[] charArray = s.toCharArray();
            //计算不变的值
            for(int l = i -1;l >= 0;l--){
                if((int)Long.parseLong(s) == nums[l]){
                    res ++;
                }
            }
            for(int j = 0;j < len;j++){
                char[] charArray1 = charArray.clone();
                char temp = charArray[j];
                for(int k = j + 1;k < len;k++){
                    //交换位置
                    char temp1 = charArray[k];
                    if(temp1 == temp){
                        continue;
                    }
                    charArray1[k] = temp;
                    charArray1[j] = temp1;
                    String replace1 = new String(charArray1);
                        for(int l = i -1;l >= 0;l--){
                            if((int)Long.parseLong(replace1) == nums[l]){
                                res ++;
                            }
                        }
                }
            }
        }
        return res;
    }



    @Test
    public void test(){
        int i = countPairs(new int[]{226726,387862,880512,611522,343461,420841,334461,10813,226726,334461,80113,314364,10813,163067,134364,332548,413463,343416,236429,164332,566432,226726,334164,343461,143463,163229,667555,667555,343461,657565,343461,770521,285866,930657,236429,502387,313446,334461,12219,163760,144363,227626});
        System.out.println(i);
    }

}
