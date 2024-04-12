package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1702
 * @Date：2024-4-10 15:21
 * @Filename：problem_1702
 */
public class problem_1702 {
    /**
     * 1702. 修改后的最大二进制字符串
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
     *
     * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
     * 比方说， "00010" -> "10010"
     * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
     * 比方说， "00010" -> "00001"
     * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
     * @param binary
     * @return
     */
    public String maximumBinaryString(String binary) {
//        int x = binary.indexOf('0');
//        char[] charArray = binary.toCharArray();
//        int count = 0;
//        for(x++; x < charArray.length; x++){
//            count += charArray[x] - '0';
//        }
//        return  "1".repeat(charArray.length - 1 - count) + '0' + "1".repeat(count);
        int i = binary.indexOf('0');
        if (i < 0) { // binary 全是 '1'
            return binary;
        }
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (i++; i < s.length; i++) {
            cnt1 += s[i] - '0'; // 统计 [i, n-1] 中 '1' 的个数
        }
//        return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
        return "1";
    }
}
