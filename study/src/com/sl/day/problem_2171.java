/**
 * @author 孙铃
 * @date 2025/3/14 13:57
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2171
 * @Date：2025/3/14
 * @Filename：problem_2171
 */
public class problem_2171 {
    /**
     * 2171. 拿出最少数目的魔法豆
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
     *
     * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。
     * 一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
     *
     * 请返回你需要拿出魔法豆的 最少数目。
     * @param beans
     * @return
     */
    public long minimumRemoval(int[] beans) {//和最大，则拿出来的最小
        Arrays.sort(beans);

        long preArr[] = new long[beans.length + 1];
        //将小的置为0，再来求
        long res = removeBeans(beans,0,preArr);




        for(int i = 1;i < beans.length;i++) {
            res = Math.min(res,removeBeans(beans,i,preArr));
        }

        return res;
    }

    private long removeBeans(int[] beans, int k, long[] preArr) {//将 k-1 置为0
        long res = 0;
        if(k == 0) {
            for(int i = 0;i < beans.length;i++) {
                res += beans[i] - beans[0];
            }
            preArr[k] = res;
            return res;
        }

        //拿到上次的结果，然后加上置为0的
        res = preArr[k -1] + beans[k];
        //拿到差值
        int temp = beans[k] - beans[k-1];
        int len = beans.length;
        res -= ((long) temp * (len - k + 1));
        preArr[k] = res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(minimumRemoval(new int[]{2,10,3,2}));
    }
}
