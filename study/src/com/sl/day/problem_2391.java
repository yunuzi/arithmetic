/**
 * @author 孙铃
 * @date 2025/2/24 10:29
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2391
 * @Date：2025/2/24
 * @Filename：problem_2391
 */
public class problem_2391 {
    /**
     * 2391. 收集垃圾的最少总时间
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。
     *
     * 同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。
     *
     * 城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。但它们 不是必须 到达所有的房子。
     *
     * 任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。
     *
     * 请你返回收拾完所有垃圾需要花费的 最少 总分钟数
     * @param garbage
     * @param travel
     * @return
     */
    public int garbageCollection(String[] garbage, int[] travel) {
//        int res = 0;
//        int carM = 0;
//        int carP = 0;
//        int carG = 0;
//        //先收集M
//        for(int i = 0;i < garbage.length;i++) {
//            int m = containsLength(garbage[i],'M');
//            int p = containsLength(garbage[i],'P');
//            int g = containsLength(garbage[i],'G');
//            //如果有M，则收集M，并更新M的位置
//            if(m > 0) {
//                res += m;
//                int temp = carM;
//                carM = i;
//                for(int j = temp;j < carM;j++) {
//                    res += travel[j];
//                }
//            }
//            if(p > 0) {
//                res += p;
//                int temp = carP;
//                carP = i;
//                for(int j = temp;j < carP;j++) {
//                    res += travel[j];
//                }
//            }
//            if(g > 0) {
//                res += g;
//                int temp = carG;
//                carG = i;
//                for(int j = temp;j < carG;j++) {
//                    res += travel[j];
//                }
//            }
//        }
//        return res;

        int cost = 0;
        for (int t : travel) {
            cost += 3 * t;
        }
        for (String s : garbage) {
            cost += s.length();
        }
        for (char c : new char[] {'M', 'P', 'G'}) {
            for (int i = garbage.length - 1; i > 0 && garbage[i].indexOf(c) < 0; i--) {
                cost -= travel[i - 1];
            }
        }
        return cost;
    }

    public int containsLength(String str,char c) {
        char[] charArray = str.toCharArray();
        if(!str.contains(String.valueOf(c))) {
            return 0;
        }
        int temp = 0;
        for(char chr : charArray){
            if(chr == c){
                temp++;
            }
        }
        return temp;
    }
}
