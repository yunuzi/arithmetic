/**
 * @author 孙铃
 * @date 2025/4/30 14:30
 */
package com.sl.dp;

import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_95
 * @Date：2025/4/30
 * @Filename：problem_95
 */
public class problem_95 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *95. 不同的二叉搜索树 II
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * @param n
     * @return
     */

    //回溯可以写，转换成dp

    public List<TreeNode> generateTrees(int n) {


        return null;
    }

    public int findNumbers(int[] nums) {
        int len = nums.length;
        int res = 0;
        for(int i = 0;i < len;i++) {
            if(String.valueOf(nums[i]).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
