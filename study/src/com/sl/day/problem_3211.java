/**
 * @author 孙铃
 * @date 2024/10/29 11:40
 */
package com.sl.day;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3211
 * @Date：2024/10/29
 * @Filename：problem_3211
 */
public class problem_3211 {
    /**
     * 3211. 生成不含相邻零的二进制字符串
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个正整数 n。
     *
     * 如果一个二进制字符串 x 的所有长度为 2 的
     * 子字符串
     * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
     *
     * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
     * @param n
     * @return
     */
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, n, path, ans);
        return ans;
    }
    private void dfs(int i, int n, char[] path, List<String> ans) {
        if (i == n) {
            ans.add(new String(path));
            return;
        }
        // 填 1
        path[i] = '1';
        dfs(i + 1, n, path, ans);
            // 填 0
        if (i== 0 || path[i - 1] == '1') {
            path[i] = '0'; // 直接覆盖
            dfs(i + 1, n, path, ans);
        }
    }


    @Test
    public void test(){
        List<String> strings = validStrings(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}






















