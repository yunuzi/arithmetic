/**
 * @author 孙铃
 * @date 2024/12/18 15:55
 */
package com.sl.random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_886
 * @Date：2024/12/18
 * @Filename：problem_886
 */
public class problem_886 {

    /**
     * 886. 可能的二分法
     * 中等
     * 相关标签
     * 相关企业
     * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
     *
     * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n <=2) {
            return true;
        }
        //排序
        for(int i = 0;i < dislikes.length;i++) {
            if(dislikes[i][0] > dislikes[i][1]) {
                int temp = dislikes[i][0];
                dislikes[i][0] = dislikes[i][1];
                dislikes[i][1] = temp;
            }
        }
        //再根据第一个数字进行排序
        Arrays.sort(dislikes, Comparator.comparingInt(a -> a[0]));


        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(dislikes[0][0]);
        right.add(dislikes[0][1]);

        for(int i = 1;i < dislikes.length;i++) {
            boolean contains = left.contains(dislikes[i][0]);
            boolean contains1 = right.contains(dislikes[i][0]);
            boolean contains2 = left.contains(dislikes[i][1]);
            boolean contains3 = right.contains(dislikes[i][1]);
            if(contains && contains2) {
                return false;
            }
            if(contains1 && contains3) {
                return false;
            }
            if(!contains && !contains1 && !contains2 && !contains3) {
                left.add(dislikes[i][0]);
                right.add(dislikes[i][1]);
                continue;
            }
            if(!contains2 && !contains3 && contains) {
                right.add(dislikes[i][1]);
                continue;
            }
            if(!contains2 && !contains3 && contains1) {
                left.add(dislikes[i][1]);
                continue;
            }
            if(!contains && !contains1 && contains2) {
                right.add(dislikes[i][0]);
                continue;
            }
            if(!contains && !contains1 && contains3) {
                left.add(dislikes[i][0]);
            }
        }
        return true;
    }

    @Test
    public void test() {
//        boolean b = possibleBipartition(10, new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}});
//        System.out.println(b);

        // 异步生成 "Hello"
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> "Hello");

        // 在 "Hello" 后面添加 " World"
        CompletableFuture<String> helloWorldFuture = helloFuture.thenApply(s -> s + " World");

        // 打印结果
        CompletableFuture<Void> printFuture = helloWorldFuture.thenAccept(System.out::println);

        // 阻塞等待所有任务完成
        try {
            printFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}

//[[1,2],[3,4],[5,6],[6,7],[8,9],[7,8]]
















