/**
 * @author 孙铃
 * @date 2024/12/18 14:27
 */
package com.sl.random;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_563
 * @Date：2024/12/18
 * @Filename：problem_563
 */
public class problem_563 {

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
     * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
     *
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     *
     * 整个树 的坡度就是其所有节点的坡度之和。
     * @param root
     * @return
     */
    private int result;

    public int findTilt(TreeNode root) {
        this.result = 0;
        dfs(root);
        return this.result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        this.result += Math.abs(left - right);
        return left + right + root.val;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int tilt = findTilt(root);
        System.out.println(tilt);
    }

}
