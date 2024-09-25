package com.sl.day;

import java.util.LinkedList;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_390
 * @Date：2024-9-14 12:06
 * @Filename：problem_390
 */
public class problem_390 {
    /**
     * 2390. 从字符串中移除星号
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个包含若干星号 * 的字符串 s 。
     *
     * 在一步操作中，你可以：
     *
     * 选中 s 中的一个星号。
     * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
     * 返回移除 所有 星号之后的字符串。
     *
     * 注意：
     *
     * 生成的输入保证总是可以执行题面中描述的操作。
     * 可以证明结果字符串是唯一的。
     * @param s
     * @return
     */
    public String removeStars(String s) {
        //单调栈
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
