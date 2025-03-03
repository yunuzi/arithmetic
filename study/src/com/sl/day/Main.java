package com.sl.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

//    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        // 注意 hasNext 和 hasNextLine 的区别
////        String s1 = in.nextLine();
////        System.out.println();
////        String s2 = in.nextLine();
////        int result = 0;
////        s1 = s1.toLowerCase();
////       s2 = s2.toLowerCase();
////        for(int i = 0;i < s1.length();i++){
////            if(s1.charAt(i) == s2.charAt(0)){
////                result++;
////            }
////        }
////        System.out.println(s1);
////        System.out.println(result);
//
//        Scanner in = new Scanner(System.in);
//        int money = in.nextInt();
//        int m = in.nextInt();
//        in.nextLine();
//        //因为money时10的倍数，所以我们可以除以10，以便后续遍历
//        money /= 10;
//        int [][] price = new int[m + 1][3];
//        int [][] weigh = new int[m + 1][3];
//        for(int i = 1;i <= m;i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int c = in.nextInt();
//            a /= 10;//price
//            b = b * a;//weight
//            if(c == 0){
//                price[i][0] = a;
//                weigh[i][0] = b;
//            } else if (price[c][1] == 0) {
//                //放入附件1
//                 price[c][1] = a;
//                 weigh[c][1] = b;
//            }else {
//                price[c][2] = a;
//                weigh[c][2] = b;
//            }
//            in.nextLine();
//        }
//        int dp[][] = new int[m + 1][money + 1];
//        //dp
//        for(int i = 1;i <= m;i++){
//            for(int j = 1;j <= money;j++){
//                int a = price[i][0];
//                int aWeight = weigh[i][0];
//                int b = price[i][1];
//                int bWeight = weigh[i][1];
//                int c = price[i][2];
//                int cWeight = weigh[i][2];
//                dp[i][j] = j - a >= 0? Math.max(dp[i - 1][j],dp[i - 1][j - a] + aWeight) : dp[i - 1][j];
//                dp[i][j] = j - a - b >= 0? Math.max(dp[i][j],dp[i - 1][j - a - b] + aWeight + bWeight) : dp[i][j];
//                dp[i][j] = j - a - c >= 0? Math.max(dp[i][j],dp[i - 1][j - a - c] + aWeight + cWeight) : dp[i][j];
//                dp[i][j] = j - a - b - c >= 0? Math.max(dp[i][j],dp[i - 1][j - a - b - c] + aWeight + bWeight + cWeight) : dp[i][j];
//            }
//        }
//        System.out.println(dp[m][money] * 10);
//    }



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


        public static int M = 5;
        public static int N = 6;
        public static void main(String[] args){
            // input
            Scanner in = new Scanner(System.in);
            int[][] initStatus = new int[M][];
            int[][] press = new int[M][];
            for(int i = 0; i < M; i++){
                initStatus[i] = new int[N];
                press[i] = new int[N];
                for(int j = 0; j < N; j++){
                    initStatus[i][j] = in.nextInt();
                }
            }

            int t;
            press[0][0] = -1;
            for(int i = 0; i < (int) Math.pow(2, N); i++){
                press[0][0]++;
                // 2=>0 1
                t = 0;
                while(press[0][t] > 1){
                    press[0][t] = 0;
                    t++;
                    press[0][t]++;
                }

                // for (int[] line : press) {
                //   for (int item : line) {
                //     System.out.printf("%d ", item);
                //   }
                //   System.out.println();
                // }
                // System.out.println(i);

                if(guess(press, initStatus)){
                    for (int[] line : press) {
                        for (int item : line) {
                            System.out.printf("%d ", item);
                        }
                        System.out.println();
                    }
                    return ;
                }
                // cleanPress(press);
            }
        }

        // clear press array
        public static void cleanPress(int[][] press){
            for(int[] one: press){
                Arrays.fill(one, 0);
            }
        }

        public static boolean guess(int[][] press, int[][] initStatus){
            // left right top bottom left-top left-bottom right-top right-bottom
            for(int i = 1; i < M; i++){
                for(int j = 0; j < N; j++){
                    // 5 value determine nowValue
                    press[i][j] = ( press[i-1][j] + initStatus[i-1][j] + (i-2>=0?press[i-2][j]:0) + (j-1>=0?press[i-1][j-1]:0) + (j+1<N?press[i-1][j+1]:0) ) % 2;
                }
            }

            for(int i = 0; i < N; i++){
                int t = (initStatus[M-1][i] + press[M-1][i] + (i-1>=0 ? press[M-1][i-1] : 0)+ (i+1<N ? press[M-1][i+1] : 0) + press[M-2][i]) % 2;
                if(t != 0) {
                    return false;
                }
            }

            return true;
        }

}
