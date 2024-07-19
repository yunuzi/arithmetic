package com.sl.od;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Author：sl
 * @Package：com.sl.od
 * @Project：arithmetic
 * @name：HJ17
 * @Date：2024-7-10 11:33
 * @Filename：HJ17
 */
public class HJ17 {
    /**
     * 描述
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     *
     * 输入：
     *
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     *
     * 坐标之间以;分隔。
     *
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     *
     * 下面是一个简单的例子 如：
     *
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     *
     * 处理过程：
     *
     * 起点（0,0）
     *
     * +   A10   =  （-10,0）
     *
     * +   S20   =  (-10,-20)
     *
     * +   W10  =  (-10,-10)
     *
     * +   D30  =  (20,-10)
     *
     * +   x    =  无效
     *
     * +   A1A   =  无效
     *
     * +   B10A11   =  无效
     *
     * +  一个空 不影响
     *
     * +   A10  =  (10,-10)
     *
     * 结果 （10， -10）
     *
     * 数据范围：每组输入的字符串长度满足
     * 1
     * ≤
     * 𝑛
     * ≤
     * 10000
     *
     * 1≤n≤10000  ，坐标保证满足
     * −
     * 2
     * 31
     * ≤
     * 𝑥
     * ,
     * 𝑦
     * ≤
     * 2
     * 31
     * −
     * 1
     *
     * −2
     * 31
     *  ≤x,y≤2
     * 31
     *  −1  ，且数字部分仅含正数
     * 输入描述：
     * 一行字符串
     *
     * 输出描述：
     * 最终坐标，以逗号分隔
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            String[] split = str.split(";");
            int x = 0;
            int y = 0;
            for(int i = 0;i<split.length;i++){
                if(split[i].length()>1){
                    if(split[i].charAt(0)=='A'){
                        String substring = split[i].substring(1);
                        if(substring.length() <=2){
                            if(!substring.matches("[0-9]+")){
                                continue;
                            }else {
                                x = x-Integer.parseInt(substring);
                            }
                        }
                    }
                    if(split[i].charAt(0)=='D'){
                        String substring = split[i].substring(1);
                        if(substring.length() <=2){
                            if(!substring.matches("[0-9]+")){
                                continue;
                            }else {
                                x = x+Integer.parseInt(substring);
                            }
                        }
                    }
                    if(split[i].charAt(0)=='W'){
                        String substring = split[i].substring(1);
                        if(substring.length() <=2){
                            if(!substring.matches("[0-9]+")){
                                continue;
                            }else {
                                y = y+Integer.parseInt(substring);
                            }
                        }
                    }
                    if(split[i].charAt(0)=='S'){
                        String substring = split[i].substring(1);
                        if(substring.length() <=2){
                            if(!substring.matches("[0-9]+")){
                                continue;
                            }else {
                                y = y-Integer.parseInt(substring);
                            }
                        }
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
}
