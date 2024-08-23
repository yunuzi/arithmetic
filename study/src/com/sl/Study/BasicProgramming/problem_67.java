package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_67
 * @Date：2024-7-29 9:47
 * @Filename：problem_67
 */
public class problem_67 {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}
