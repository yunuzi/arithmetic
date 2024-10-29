package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3132
 * @Date：2024-8-9 13:05
 * @Filename：problem_3132
 */
public class problem_3132 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        //删除连个元素：排序后，我们要想得到最小的，则只可能出现三张情侣， 从 0，开始 ，从1，开始，从2开始
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] visable = new int[1001];
        for(int i = 0;i < nums2.length;i++){
            visable[nums2[i]] += 1;
        }
        int res = nums2[0] - nums1[0];
        for(int i = 2; i >= 0;i--){
            int [] tempVisable = new int[1001];
            tempVisable = Arrays.copyOf(visable, 1001);
            int add = nums2[0] - nums1[i];
            for(int j = 0; j < nums1.length;j++){
                if(nums1[j] + add < 1001 && nums1[j] + add >= 0 && tempVisable[nums1[j] + add] > 0){
                    tempVisable[nums1[j] + add] -= 1;
                }
            }
            boolean flag = true;
            for(int j = 0; j < 1001;j++){
                if(tempVisable[j] != 0){
                    flag = false;
                    continue;
                }
            }
            if(flag){
                res = Math.min(res, add);
            }
        }
        return res;

        /**
         *         int len1 = nums1.length;
         *         int len2 = nums2.length;
         *         int sum1 = 0;
         *         int sum2 = 0;
         *         Arrays.sort(nums1);
         *         Arrays.sort(nums2);
         *         for (int i = 2; i >0 ; i--) {
         *             int x=nums2[0]-nums1[i];
         *             int j=0;
         *             for (int k = 0; k < nums1.length; k++) {
         *                 if (nums2[j]==nums1[k]+x&&++j==nums2.length){
         *                     return x;
         *                 }
         *             }
         *         }
         *         return nums2[0]-nums1[0];
         */
    }

    @Test
    public void test(){
        System.out.println(minimumAddedInteger(new int[]{2, 6, 7, 8, 7}, new int[]{5, 6, 7}));
    }
}
