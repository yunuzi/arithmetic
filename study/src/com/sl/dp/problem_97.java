/**
 * @author 孙铃
 * @date 2025/5/12 14:51
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_97
 * @Date：2025/5/12
 * @Filename：problem_97
 */
public class problem_97 {
    /**
     * 97. 交错字符串
     * 中等
     * 相关标签
     * 相关企业
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     *
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     *
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     * @param s1
     * @param s2
     * @param s3
     * @return
     *
     * 提示：
     *
     * 0 <= s1.length, s2.length <= 100
     * 0 <= s3.length <= 200
     * s1、s2、和 s3 都由小写英文字母组成
     *
     *
     * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        return false;
    }
}
