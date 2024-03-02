package com.sl.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_589
 * @Date：2024-2-18 11:33
 * @Filename：problem_589
 */
public class problem_589 {

    public List<Integer> resList = new ArrayList<Integer>();

    /**
     * 589. N 叉树的前序遍历
     * 简单
     * 相关标签
     * 相关企业
     * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
     *
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        checkFun(root);
        return resList;
    }

    private void checkFun(Node node) {
        if(node == null){
            return;
        }
        resList.add(node.val);
        for(Node n : node.children){
            checkFun(n);
        }
    }


    // Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


}
