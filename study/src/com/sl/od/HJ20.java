/**
 * @author 孙铃
 * @date 2025/4/28 16:50
 */
package com.sl.od;
import java.util.Scanner;
import java.util.HashMap;



/**
 * @Author：孙铃
 * @Package：com.sl.od
 * @Project：arithmetic
 * @name：HJ20
 * @Date：2025/4/28
 * @Filename：HJ20
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String str = in.nextLine();
            //ascill  33-126
            char[] chars =str.toCharArray();
            if(chars.length < 8){
                System.out.println("NG");
                continue;
            }
            //条件2判断
            int diffentCount = 0;
            boolean isNum = false;
            boolean isUpper = false;
            boolean isLower = false;
            boolean isSpecial = false;
            for(int i = 0;i < chars.length;i++) {
                if(diffentCount >= 3) {
                    break;
                }
                if(chars[i] >=48 && chars[i] <= 57) {
                    if(!isNum) {
                        isNum = true;
                        diffentCount++;
                    }
                }else if(chars[i] >=65 && chars[i] <= 90) {
                    if(!isUpper) {
                        isUpper = true;
                        diffentCount++;
                    }
                }else if(chars[i] >=97 && chars[i] <= 122) {
                    if(!isLower) {
                        isLower = true;
                        diffentCount++;
                    }
                }else if((chars[i] >=33 && chars[i] <= 47) || (chars[i] >=58 && chars[i] <= 64) || (chars[i] >=91 && chars[i] <= 96) || (chars[i] >=123 && chars[i] <= 126) ) {
                    if(!isSpecial) {
                        isSpecial = true;
                        diffentCount++;
                    }
                }
            }
            // 398h$720CD0h&7f9~A403mex~lu#$*0+0CD0
//            System.out.println(diffentCount);
//            System.out.println(isNum);
//            System.out.println(isUpper);
//            System.out.println(isLower);
//            System.out.println(isSpecial);
            if(diffentCount < 3) {
                System.out.println("NG");
                continue;
            }

            //条件3判断 不能存在长度大于2的字符串
            boolean isContain = false;
            HashMap<String,Integer> map = new HashMap<>();
            for(int i = 0;i < chars.length;i++) {
                for(int j = i + 3;j <= chars.length;j++){
                    map.put(str.substring(i, j), map.getOrDefault(str.substring(i, j), 0) + 1);
                    if(map.get(str.substring(i,j)) >= 2) {
                        isContain = true;
                        break;
                    }
                }
            }
            if(isContain) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
