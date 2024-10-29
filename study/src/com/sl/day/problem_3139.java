/**
 * @author 孙铃
 * @date 2024/10/18 14:34
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3139
 * @Date：2024/10/18
 * @Filename：problem_3139
 */
public class problem_3139 {
    /**
     * 问：为什么这样做是对的？
     *
     * 答：
     *
     * 先操作 i 再操作 j（i
     * 
     * =j），和先操作 j 再操作 i 的结果是一样的，所以操作顺序不影响答案。既然操作顺序无影响，我们可以从左到右操作。或者说，假设某种操作顺序是最优的，那么总是可以把这个操作顺序重排成从左到右操作。
     * 对于同一个 i，操作两次等于没有操作，所以同一个 i 至多操作一次。注：操作 i 指的是反转 i,i+1,i+2 这三个位置。
     * 结合上述两点，既然同一个 i 至多操作一次，那么从左到右操作的过程中，遇到 1 一定不能操作，遇到 0 一定要操作，所以从左到右的操作方式有且仅有一种。
     * 既然操作方式是唯一的，我们只需模拟这个过程。
     * 问：题目要求的「最少」体现在哪里？
     *
     * 答：对同一个 i 至多操作一次，就可以做到最少的操作次数。
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int len = nums.length;
        int res = 0;
        for(int i = 0;i < len - 2;i++){
            if(nums[i] == 0 && i < len - 3){
                //反转
                nums[i] = 1;
                if(nums[i + 1] == 1){
                    nums[i + 1] = 0;
                }else{
                    nums[i + 1] = 1;
                }
                if(nums[i + 2] == 1){
                    nums[i + 2] = 0;
                }else{
                    nums[i + 2] = 1;
                }
                res++;
            }
        }
        if(nums[len - 3] == 0 && nums[len - 2] == 0 && nums[len - 1] == 0){
            return res + 1;
        }
        if(nums[len -3] == 1 && nums[len -2] == 1 && nums[len -1] == 1){
            return res;
        }
        return -1;
    }
}
