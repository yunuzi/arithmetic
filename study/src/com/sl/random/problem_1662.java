/**
 * @author 孙铃
 * @date 2024/10/18 15:07
 */
package com.sl.random;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_1662
 * @Date：2024/10/18
 * @Filename：problem_1662
 */
public class problem_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().contentEquals(sb2);
    }
}
