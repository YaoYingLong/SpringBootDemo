package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.NTreeNode;
import com.nokia.example.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author by YingLong on 2020/7/27
 */
public class TreeTraversal {

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
     */
    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthV1(root.left), maxDepthV1(root.right)) + 1;
    }

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 543
     * 二叉树的直径
     */
    int diameter = 0;

    public int diameter(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }


    /**
     * 107
     * 二叉树的层次遍历 II
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(0, levelList);
        }
        return resultList;
    }

    /**
     * 606
     * 根据二叉树创建字符串
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = root.val + "";
        if (root.left == null && root.right == null) {
            return result;
        }
        result += "(" + tree2str(root.left) + ")";
        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }
        return result;
    }

    /**
     * 993
     * 二叉树的堂兄弟节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int xIndex = -1, yIndex = -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.val == x) {
                    xIndex = i;
                }
                if (node.val == y) {
                    yIndex = i;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (yIndex == -1 || xIndex == -1) {
                continue;
            }
            if (Math.abs(yIndex - xIndex) > 1 || Math.max(xIndex, yIndex) % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 559
     * N叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (NTreeNode node : root.nodes) {
            maxDepth = Math.max(maxDepth(node), maxDepth);
        }
        return maxDepth + 1;
    }
}
