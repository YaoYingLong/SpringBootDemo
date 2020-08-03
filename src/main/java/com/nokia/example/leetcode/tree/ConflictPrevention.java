package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * @author by YingLong on 2020/8/1
 */
public class ConflictPrevention {

    /**
     * 687
     * 最长同值路径
     *
     * @param root
     * @return
     */
    public int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        traversal(root);
        return longest;
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        longest = Math.max(longest, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }


    TreeNode ans;
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode treeNode = new TreeNode();
        ans = treeNode;
        convertInorder(root);
        return treeNode.right;
    }

    public void convertInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        convertInorder(root.left);
        root.left = null;
        ans.right = root;
        ans = root;
        convertInorder(root.right);
    }
}
