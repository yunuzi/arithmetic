package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_45
 * @Date：2023-12-18 14:03
 * @Filename：problem_45
 */
public class problem_45 {
    /**
     * 45. 跳跃游戏 II
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int jumpMax = nums[0];
        int count = 1;
        int len = nums.length - 1;
        //记录一次跳跃中，这其中可跳跃的最大返回
        int currentMax = 0;
        for(int i = 0;i <= jumpMax;i++){
            if(jumpMax >= len){
                return count;
            }
            //当前可跳跃的最大范围
            if( i + nums[i] > currentMax ){
                currentMax = i + nums[i];
            }
            //若走到这一步，则说明这次跳跃到不了最后，则将count++
            if(i == jumpMax){
                jumpMax = currentMax;
                count++;
            }


        }
        return count;
    }
}
