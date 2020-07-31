package com.nokia.leetcode;

import com.nokia.example.leetcode.entity.TreeNode;
import com.nokia.example.leetcode.tree.SearchTree;
import com.nokia.example.leetcode.tree.TreeTraversal;
import org.junit.Test;

/**
 * @author by YingLong on 2020/7/30
 */
public class TreeTest {

    @Test
    public void isCousinsTest() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(TreeTraversal.isCousins(node1, 2, 3));
    }

    @Test
    public void increasingBSTTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode node6 = new TreeNode(6, null, node8);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node5 = new TreeNode(5, node3, node6);

        SearchTree searchTree = new SearchTree();
        TreeNode result = searchTree.increasingBST(node5);

    }
}
