/**
 * @author 孙铃
 * @date 2024/6/5 1:54
 */
package com.sl.may;

import java.util.Arrays;

/**
 * @author 铃
 * @date 2024/6/5 1:54
 */
public class day04 {
    /**
     * 1822. 数组元素积的符号
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
     *
     * 如果 x 是正数，返回 1 。
     * 如果 x 是负数，返回 -1 。
     * 如果 x 是等于 0 ，返回 0 。
     * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
     *
     * 返回 signFunc(product) 。
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int res = 2;
        for(Integer num : nums){
            if(num < 0){
                res++;
            }
            if(num == 0){
                return 0;
            }
        }
        return res % 2 == 0 ? 1 : -1;
    }


    /**
     * 1502. 判断能否形成等差数列
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个数字数组 arr 。
     *
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     *
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i] - arr[i - 1] != arr[i + 1] - arr[i]){
                return false;
            }
        }

        return true;
    }


    /**
     * 896. 单调数列
     * 简单
     * 相关标签
     * 相关企业
     * 如果数组是单调递增或单调递减的，那么它是 单调 的。
     *
     * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。
     * 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
     *
     * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
     * @param nums
     * @return
     */
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1 || nums.length == 2){
            return true;
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                continue;
            }
            if(nums[i] < nums[i + 1]){
                for(int j = i + 1; j < nums.length - 1; j++){
                    if(nums[j] > nums[j + 1]){
                        return false;
                    }
                }
                return true;
            }
            if(nums[i] > nums[i + 1]){
                for(int j = i + 1; j < nums.length - 1; j++){
                    if(nums[j] < nums[j + 1]){
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }


    /**
     * 709. 转换成小写字母
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] >= 'A' && charArray[i] <= 'Z'){
                charArray[i] += 32;
            }
        }
        return new String(charArray);
    }
}
