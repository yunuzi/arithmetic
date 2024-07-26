package com.sl.backtracking;

/**
 * @Author：sl
 * @Package：com.sl.backtracking
 * @Project：arithmetic
 * @name：day_10
 * @Date：2024-4-3 11:43
 * @Filename：day_10
 */
public class day_10 {


//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }


    public TreeNode tree;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
         findTarget(cloned,target.val);
         return tree;
    }

    public final void findTarget(final TreeNode cloned, int target){
        if(cloned == null) {
            return;
        }
        if(cloned.val == target){
            tree = cloned;
            return;
        }
        findTarget(cloned.left,target);
        findTarget(cloned.right,target);
    }
}
