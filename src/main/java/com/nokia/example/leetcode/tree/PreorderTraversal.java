package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * 前序遍历相关的题
 *
 * @author by YingLong on 2020/7/31
 */
public class PreorderTraversal {

    /**
     * 404
     * 左叶子之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeaves(root.right, false);
    }

    public int leftLeaves(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return flag ? root.val : 0;
        }
        int leftVal = leftLeaves(root.left, true);
        int rightVal = leftLeaves(root.right, false);
        return leftVal + rightVal;
    }

    /**
     * 404
     * 左叶子之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeavesV2(root.left);
            }
        }
        if (root.right != null) {
            ans += sumOfLeftLeavesV2(root.right);
        }
        return ans;
    }

    /**
     * 572
     * 另一个树的子树
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

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


    /**
     * 617
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 剑指 Offer 26
     * 树的子结构
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
