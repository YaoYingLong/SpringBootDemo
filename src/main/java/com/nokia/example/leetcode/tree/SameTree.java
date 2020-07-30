package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * @author by YingLong on 2020/7/29
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;

        }
        boolean isSame = isSameTree(p.left, q.left);
        if (!isSame) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }
}
