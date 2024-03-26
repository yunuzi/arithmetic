package com.sl.day;

import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.nextLine();
        System.out.println();
        String s2 = in.nextLine();
        int result = 0;
        s1 = s1.toLowerCase();
       s2 = s2.toLowerCase();
        for(int i = 0;i < s1.length();i++){
            if(s1.charAt(i) == s2.charAt(0)){
                result++;
            }
        }
        System.out.println(s1);
        System.out.println(result);


    }



    class ProductOfNumbers {

       public ArrayList<Integer> list;
       int len;

        public ProductOfNumbers() {
            list = new ArrayList<>();
            list.add(1);
            int len = 0;
        }

        public void add(int num) {
            if(num == 0){
                len = 0;
            }else {
                len++;
                list.add(len,num * list.get(len - 1));
            }
        }

        public int getProduct(int k) {
            if(k > len){
                return 0;
            }else {
                return list.get(len) / list.get(len - k);
            }
        }
    }
}