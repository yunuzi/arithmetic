package com.sl.day;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：arithmetic_407
 * @Date：2024-7-22 8:53
 * @Filename：arithmetic_407
 */
public class arithmetic_407 {
    /**
     * 100372. 使两个整数相等的位更改次数
     * 简单
     * 相关企业
     * 提示
     * 给你两个正整数 n 和 k。
     *
     * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
     *
     * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
     * @param n
     * @param k
     * @return
     */
    public int minChanges(int n, int k) {
        if(n == k){
            return 0;
        }
        int arr[] = new int[32];
        int m = n;
        int t = 0;
        while(m != 0){
            if(m == 1){
                arr[t++] = 1;
                m = 0;
            }else {
                int temp = dep(m);
                arr[t++] = temp;
                m -= temp;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < t; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        int res = 0;
        while(k != 0){
            if(k == 1){
                if(map.containsKey(1)){
                    res++;
                }else {
                    return -1;
                }
                k = 0;
            }else{
                int temp = dep(k);
                if(map.containsKey(temp)){
                    res++;
                }else {
                    return -1;
                }
                k -= temp;
            }
        }
        return map.size() - res;
    }

    public int dep(int n){
        int dep = 1;
        while(dep <= n){
            dep = dep << 1;
        }
        return dep >> 1;
    }


    /**
     * 100335. 字符串元音游戏
     * 中等
     * 相关企业
     * 提示
     * 小红和小明在玩一个字符串元音游戏。
     *
     * 给你一个字符串 s，小红和小明将轮流参与游戏，小红 先 开始：
     *
     * 在小红的回合，她必须移除 s 中包含 奇数 个元音的任意 非空
     * 子字符串
     * 。
     * 在小明的回合，他必须移除 s 中包含 偶数 个元音的任意 非空
     * 子字符串
     * 。
     * 第一个无法在其回合内进行移除操作的玩家输掉游戏。假设小红和小明都采取 最优策略 。
     *
     * 如果小红赢得游戏，返回 true，否则返回 false。
     *
     * 英文元音字母包括：a, e, i, o, 和 u。
     * @param s
     * @return
     */
    public boolean doesAliceWin(String s) {
        int temp = 0;
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                temp++;
            }
        }
        if(temp == 0){
            return false;
        }
            return true;
    }

    /**
     * 100360. 将 1 移动到末尾的最大操作次数
     * 中等
     * 相关企业
     * 提示
     * 给你一个
     * 二进制字符串
     *  s。
     *
     * 你可以对这个字符串执行 任意次 下述操作：
     *
     * 选择字符串中的任一下标 i（ i + 1 < s.length ），该下标满足 s[i] == '1' 且 s[i + 1] == '0'。
     * 将字符 s[i] 向 右移 直到它到达字符串的末端或另一个 '1'。例如，对于 s = "010010"，如果我们选择 i = 1，结果字符串将会是 s = "000110"。
     * 返回你能执行的 最大 操作次数。
     * @param s
     * @return
     */
    public int maxOperations(String s) {//1001101
        char[] charArray = s.toCharArray();
        int res = 0;
        int temp = 0;
        for(int i = 0; i < charArray.length - 1; i++){
            if(charArray[i] == '1' && charArray[i + 1] == '1'){
                temp++;
            }else if(charArray[i] == '1' && charArray[i + 1] == '0'){
                temp++;
                res += temp;
            }
        }
        return res;
    }

    /**
     * 100329. 使数组等于目标数组所需的最少操作次数
     * 困难
     * 相关企业
     * 提示
     * 给你两个长度相同的正整数数组 nums 和 target。
     *
     * 在一次操作中，你可以选择 nums 的任何
     * 子数组
     * ，并将该子数组内的每个元素的值增加或减少 1。
     *
     * 返回使 nums 数组变为 target 数组所需的 最少 操作次数。
     *
     *
     * @param nums
     * @param target
     * @return
     */
        public long minimumOperations(int[] nums, int[] target) {
            long s = target[0] - nums[0];
            long ans = Math.abs(s);
            for (int i = 1; i < nums.length; i++) {
                int k = (target[i] - target[i - 1]) - (nums[i] - nums[i - 1]);
                if (k > 0) {
                    ans += s >= 0 ? k : Math.max(k + s, 0);
                } else {
                    ans -= s <= 0 ? k : Math.min(k + s, 0);
                }
                s += k;
            }
            return ans;
        }

    @Test
    public void test(){
        minimumOperations(new int[]{9,2,6,10,4,8,3,4,2,3}, new int[]{9,5,5,1,7,9,8,7,6,5});
    }

}
