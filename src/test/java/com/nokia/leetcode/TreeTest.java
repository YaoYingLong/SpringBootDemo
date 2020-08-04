package com.nokia.leetcode;

import com.nokia.example.leetcode.entity.TreeNode;
import com.nokia.example.leetcode.tree.BackorderTraversal;
import com.nokia.example.leetcode.tree.BfsTraversal;
import com.nokia.example.leetcode.tree.SearchTree;
import com.nokia.example.leetcode.tree.TreeTraversal;
import org.junit.Test;

import java.util.Random;

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
    @Test
    public void findSecondMinimumValueTest() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2, node1, node2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2, node4, node3);

        BackorderTraversal backorderTraversal = new BackorderTraversal();
        int result = backorderTraversal.findSecondMinimumValue(node5);
        System.out.println(result);
    }

    @Test
    public void leafSimilarTest() {
        /**
         * [3,5,1,6,2,9,8,null,null,7,4]
         * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
         */
        TreeNode node14 = new TreeNode(4);
        TreeNode node17 = new TreeNode(7);
        TreeNode node16 = new TreeNode(6);
        TreeNode node15 = new TreeNode(5, node16, node17);
        TreeNode node19 = new TreeNode(9);
        TreeNode node18 = new TreeNode(8);
        TreeNode node12 = new TreeNode(2, node19, node18);
        TreeNode node11 = new TreeNode(1, node14, node12);
        TreeNode node13 = new TreeNode(3, node15, node11);

        TreeNode node24 = new TreeNode(4);
        TreeNode node27 = new TreeNode(7);
        TreeNode node22 = new TreeNode(2, node27, node24);
        TreeNode node26 = new TreeNode(6);
        TreeNode node25 = new TreeNode(5, node26, node22);
        TreeNode node29 = new TreeNode(9);
        TreeNode node28 = new TreeNode(8);
        TreeNode node21 = new TreeNode(1, node29, node28);
        TreeNode node23 = new TreeNode(3, node25, node21);

        BfsTraversal bfsTraversal = new BfsTraversal();
        System.out.println(bfsTraversal.leafSimilar(node23, node13));
    }

    @Test
    public void lowestCommonAncestorTest() {
        {
            TreeNode node0 = new TreeNode(0);
            TreeNode node4 = new TreeNode(4);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);
            TreeNode node8 = new TreeNode(8);
            TreeNode node2 = new TreeNode(2, node7, node4);
            TreeNode node1 = new TreeNode(1, node0, node8);
            TreeNode node5 = new TreeNode(5, node6, node2);
            TreeNode node3 = new TreeNode(3, node5, node1);

            BackorderTraversal backorderTraversal = new BackorderTraversal();
            System.out.println(backorderTraversal.lowestCommonAncestor(node3, node5, node4));
        }
        {
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node2 = new TreeNode(2, node4, null);
            TreeNode node1 = new TreeNode(1, node2, node3);
            BackorderTraversal backorderTraversal = new BackorderTraversal();
            System.out.println(backorderTraversal.lowestCommonAncestor(node1, node4, node3));
        }
    }

    @Test
    public void findTargetTest() {
        SearchTree searchTree = new SearchTree();
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, node7);
        TreeNode node5 = new TreeNode(5, node3, node6);
        searchTree.findTarget(node5, 9);
    }
}
