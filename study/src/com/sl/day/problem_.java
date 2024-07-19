package com.sl.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_
 * @Date：2024-7-15 11:20
 * @Filename：problem_
 */
public class problem_ {
    /**
     * 3216. 交换后字典序最小的字符串
     * 简单
     * 相关企业
     * 提示
     * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
     * 字典序最小的字符串
     * 。
     *
     * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
     * @param s
     * @return
     */
    public String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length - 1; i++){
            if(charArray[i] > charArray[i+1] && check(charArray[i],charArray[i+1])){
                char temp = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i+1] = temp;
                break;
            }
        }
        return new String(charArray);
    }

    public boolean  check(char a,char b){
        if(a % 2 ==0 && b % 2 == 0){
            return true;
        }
        if(a % 2 !=0 && b % 2 != 0){
            return true;
        }
        return false;
    }

        public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode res = cur;
        while(cur.next != null){
            if(map.containsKey(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return cur.next;
    }

    /**
     * 3218. 切蛋糕的最小总开销 I
     * 中等
     * 相关企业
     * 提示
     * 有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
     *
     * 给你整数 m ，n 和两个数组：
     *
     * horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
     * verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
     * 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
     *
     * 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
     * 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
     * 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
     *
     * 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
     *
     * 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
     * @param m
     * @param n
     * @param horizontalCut
     * @param verticalCut
     * @return
     */
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        if(m == 1 && n == 1){
            return 0;
        }
        long res = 0;
        int x = 1;
        int y = 1;
        int i = horizontalCut.length - 1;
        int j = verticalCut.length -1;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        for(; i >= 0; i--){
            int temp = horizontalCut[i];
                while(j >= 0 && verticalCut[j] >= temp){
                    res += (long) y * verticalCut[j];
                    j--;
                    x++;
                }
            res += (long) x * temp;
                y++;
        }
        if(j >= 0){
            while(j >= 0){
                res += (long) y * verticalCut[j];
                j--;
                x++;
            }
        }
        return res;
    }

}
