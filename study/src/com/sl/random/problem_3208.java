/**
 * @author 孙铃
 * @date 2024/11/7 18:26
 */
package com.sl.random;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_3208
 * @Date：2024/11/7
 * @Filename：problem_3208
 */
public class problem_3208 {
    /**
     * 3208. 交替组 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 colors 和一个整数 k ，colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
     *
     * colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
     * colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
     * 环中连续 k 块瓷砖的颜色如果是 交替 颜色（也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
     *
     * 请你返回 交替 组的数目。
     *
     * 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int [] color = new int[2*len];
        int count = 0;
        int temp = 0;
        int pre = colors[0];
        for(int i = 0;i < len + k;i++){
            if(i == 0) {
                color[i] = colors[i];
                color[i + len] = colors[i];
                temp = 1;
                continue;
            }
            if(temp >= k) {
                count++;
            }
            if(i < len) {
                color[i] = colors[i];
                color[i + len] = colors[i];
            }
            if(pre != color[i]) {
                temp++;
            }else {
                temp = 1;
            }
            pre = color[i];
        }
        return count;
    }
}
