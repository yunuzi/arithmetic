package com.sl.day;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem503
 * @Date：2024-6-24 17:19
 * @Filename：problem503
 */
public class problem503 {
    public int[] nextGreaterElements(int[] nums) {
        //单调栈 从右往左
//        int [] ans = new int[nums.length];
//        Arrays.fill(ans,-1);
//        Deque<Integer> que = new ArrayDeque<>();
//        for(int i = 2 * nums.length - 1;i>=0;i--){
//            int x = nums[i % nums.length];
//            while(!que.isEmpty() && que.peek() <= x){
//                //弹出元素
//                que.pop();
//            }
//            if(i < nums.length && !que.isEmpty()){
//                ans[i] = que.peek();
//            }
//            que.push(x);
//        }
//        return ans;

        //单调栈从左往右
        //栈中记录还没算出「下一个更大元素」的那些数的下标。
        //
        //只要遍历到比栈顶元素值更大的数，就意味着栈顶元素找到了答案，记录答案，然后从栈顶弹出

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!st.isEmpty() && x > nums[st.peek()]) {
                // x 是 nums[st.peek()] 的下一个更大元素
                // 既然 nums[st.peek()] 已经算出答案，则从栈顶弹出
                ans[st.pop()] = x;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double res[] = new double[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            res[i] = (nums[i] + nums[n - 1 - i]) / 2.0;
        }
        Arrays.sort(res);
        return res[0];
    }


    public int minimumArea(int[][] grid) {
        int len[] = new int[]{grid.length,0};
        int width[]= new int[]{grid[0].length,0};

        //找到最大的长和宽
        for(int i = 0;i<grid.length;i++){
            int min = 0;
            int max = 0;
            int step = 0;
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && step == 0){
                    min = j;
                    max = j;
                }
                if(grid[i][j] == 1 && step != 0){
                    max = j;
                }
                if(grid[i][j] == 1){
                    step++;
                }

            }
            if(step != 0){
                len[0] = Math.min(len[0],min);
                len[1] = Math.max(len[1],max);
            }

        }
        for(int i = 0;i<grid[0].length;i++){
            int min = 0;
            int max = 0;
            int step = 0;
            for(int j = 0;j<grid.length;j++){
                if(grid[j][i] == 1 && step == 0){
                    min = j;
                    max = j;
                }
                if(grid[j][i] == 1 && step != 0){
                    max = j;
                }
                if(grid[j][i] == 1){
                    step++;
                }
            }
            if(step != 0){
                width[0] = Math.min(width[0],min);
                width[1] = Math.max(width[1],max);
            }
        }
        return (len[1] - len[0] + 1) * (width[1] - width[0] + 1);
    }



    public int[] findRightInterval(int[][] intervals) {
        int [][] arr = new int[intervals.length][2];
        for(int i = 0;i<intervals.length;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }
        int res[] = new int[intervals.length];
        Arrays.fill(res,-1);
        Arrays.sort(arr,(a,b)->a[0] - b[0]);
        for(int i = 0;i<intervals.length;i++){
            int l = 0;
            int r = intervals.length;
            while(l < r){
                int mid = (l + r) / 2;
                if(arr[mid][0] < intervals[i][1]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            if(l < intervals.length){
                res[i] = arr[l][0] < intervals[i][1] ? -1 : arr[l][1];
            }else {
                res[i] = -1;
            }

        }
        return res;
    }












    @Test
    public void test(){
        System.out.println(minimumArea(new int[][]{{0, 1}}));
    }



}
