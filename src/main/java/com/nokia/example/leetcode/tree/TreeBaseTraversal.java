package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author by YingLong on 2020/7/31
 */
public class TreeBaseTraversal {
    /**
     * 前序遍历
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——前序非递归遍历
     */
    public void preOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            System.out.print(tree.val);
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.print(treeNode.val);
        inOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——中序非递归遍历
     */
    public void inOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val);
            node = node.right;
        }
    }

    /**
     * 后序遍历
     */
    public void backOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        backOrder(treeNode.left);
        backOrder(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 深度优先遍历——后序非递归遍历
     */
    public void backOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            TreeNode right = null;
            while (currentNode.right == null || currentNode.right == right) {
                System.out.print(currentNode.val);
                right = currentNode;
                if (stack.isEmpty()) {
                    return;
                }
                currentNode = stack.pop();
            }
            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    public void backOrderDfsV2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> markStack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            while (!markStack.isEmpty() && markStack.peek() == stack.peek()) {
                markStack.pop();
                System.out.print(stack.pop().val);
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                markStack.push(node);
                node = node.right;
            }
        }
    }

    /**
     * 层序遍历—广度优先遍历
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
            System.out.print(tree.val);
        }
    }
}
