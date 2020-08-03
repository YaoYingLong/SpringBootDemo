package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/7/31
 */
public class BfsTraversal {

    /**
     * 872
     * 叶子相似的树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneLeafList = new ArrayList<>();
        List<Integer> treeTwoLeafList = new ArrayList<>();
        getLeafs(root1, treeOneLeafList);
        getLeafs(root2, treeTwoLeafList);
        return treeOneLeafList.equals(treeTwoLeafList);
    }

    public void getLeafs(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            resultList.add(root.val);
        }
        getLeafs(root.left, resultList);
        getLeafs(root.right, resultList);
    }
}
