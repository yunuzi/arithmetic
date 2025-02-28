/**
 * @author 孙铃
 * @date 2025/2/27 9:21
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_260
 * @Date：2025/2/27
 * @Filename：problem_260
 */
public class problem_260 {
    /**
     * 260. 只出现一次的数字 III
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     *
     * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
     * @param nums
     * @return
     */
     public int[] singleNumber(int[] nums) {
         int xorAll = 0;
         for (int x : nums) {
             xorAll ^= x;
         }
         int lowbit = xorAll & -xorAll;
         int[] ans = new int[2];
         for (int x : nums) {
             ans[(x & lowbit) == 0 ? 0 : 1] ^= x; // 分组异或
         }
         return ans;
     }
    /**
     * 【图解】一张图秒懂！转换成 136！（Python/Java/C++/Go/JS/Rust）
     *
     * 灵茶山艾府
     * 2022 感恩勋章
     * 8455
     * 2023.10.16
     * 发布于 浙江
     * 位运算
     * 图
     * 脑筋急转弯
     * C++
     *
     * 6+
     *
     *
     * 代码实现时，需要找到异或和中的某个值为 1 的比特位。
     *
     * 一种方式是计算 lowbit，只保留二进制最低位的 1，举例如下：
     *
     *      s = 101100
     *     ~s = 010011
     * (~s)+1 = 010100 // 根据补码的定义，这就是 -s   效果：s 的最低 1 左侧取反，右侧不变
     * s & -s = 000100 // lowbit
     * 更多位运算技巧，请看 从集合论到位运算，常见位运算技巧分类总结！
     *
     * class Solution {
     *     public int[] singleNumber(int[] nums) {
     *         int xorAll = 0;
     *         for (int x : nums) {
     *             xorAll ^= x;
     *         }
     *         int lowbit = xorAll & -xorAll;
     *         int[] ans = new int[2];
     *         for (int x : nums) {
     *             ans[(x & lowbit) == 0 ? 0 : 1] ^= x; // 分组异或
     *         }
     *         return ans;
     *     }
     * }
     * 也可以通过计算 xorAll 尾零的个数，直接取得 nums[i] 在该比特位上的值，从而避免逻辑判断。
     *
     * 注：如果没有计算尾零个数的库函数，可以改为计算二进制的长度减一。
     *
     * class Solution {
     *     public int[] singleNumber(int[] nums) {
     *         int xorAll = 0;
     *         for (int x : nums) {
     *             xorAll ^= x;
     *         }
     *         int tz = Integer.numberOfTrailingZeros(xorAll);
     *         int[] ans = new int[2];
     *         for (int x : nums) {
     *             ans[x >>> tz & 1] ^= x;
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为 nums 的长度。
     * 空间复杂度：O(1)。仅用到若干额外变量。
     */
}
