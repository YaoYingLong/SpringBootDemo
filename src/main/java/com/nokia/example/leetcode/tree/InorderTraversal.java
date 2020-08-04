package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/7/31
 */
public class InorderTraversal {

    /**
     * 1305
     * 两棵二叉搜索树中的所有元素
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> oneList = inorder1350(root1);
        List<Integer> twoList = inorder1350(root2);
        oneList.addAll(twoList);
        oneList.sort(Integer::compare);
        return oneList;
    }

    public List<Integer> inorder1350(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> leftList = inorder1350(root.left);
        resultList.addAll(leftList);
        resultList.add(root.val);
        List<Integer> rightList = inorder1350(root.right);
        resultList.addAll(rightList);
        return resultList;
    }
}
