package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2956
 * @Date：2024-7-16 13:47
 * @Filename：problem_2956
 */
public class problem_2956 {
    /**
     * 2956. 统计两个数组中相等元素的数目
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int arr1 [] = new int[101];
        int arr2 [] = new int[101];
        for(int i =0;i < nums1.length;i++){
            arr1[nums1[i]]++;
        }
        for(int i = 0;i < nums2.length;i++){
            arr2[nums2[i]]++;
        }
        int res [] = new int[]{0,0};
        for(int i = 0;i < nums1.length;i++){
            res[0] += arr2[nums1[i]] > 0 ? 1 : 0;
        }
        for(int i = 0;i < nums2.length;i++){
            res[1] += arr1[nums2[i]] > 0 ? 1 : 0;
        }
        return res;
    }
}
