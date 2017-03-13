package com.nokia.example.DataStructure;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/25.
 */
public class BinaryTree{

    private class BSTreeNode<T>{
        public T key;
        public BSTreeNode left;
        public BSTreeNode right;

        public BSTreeNode(T key, BSTreeNode left, BSTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public BSTreeNode(T key) {
            this.key = key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setLeft(BSTreeNode left) {
            this.left = left;
        }

        public void setRight(BSTreeNode right) {
            this.right = right;
        }
    }

    //先序遍历
    public void PreorderTraversal(BSTreeNode treeNode){
        if(treeNode != null){
            System.out.print(" "+treeNode.key);
            PreorderTraversal(treeNode.left);
            PreorderTraversal(treeNode.right);
        }
    }

    //中序遍历
    public void InorderTraversal(BSTreeNode treeNode){
        if(treeNode != null){
            PreorderTraversal(treeNode.left);
            System.out.print(" "+treeNode.key);
            PreorderTraversal(treeNode.right);
        }
    }

    //后序遍历
    public void PostorderTraversal(BSTreeNode treeNode){
        if(treeNode != null){
            PreorderTraversal(treeNode.left);
            PreorderTraversal(treeNode.right);
            System.out.print(" "+treeNode.key);
        }
    }

    @Test
    public void BSTreeTest(){
        BSTreeNode<Integer> binaryTree1 = new BSTreeNode<Integer>(1);
        BSTreeNode<Integer> binaryTree2 = new BSTreeNode<Integer>(2);
        BSTreeNode<Integer> binaryTree3 = new BSTreeNode<Integer>(3);
        BSTreeNode<Integer> binaryTree4 = new BSTreeNode<Integer>(4);
        BSTreeNode<Integer> binaryTree5 = new BSTreeNode<Integer>(5);
        BSTreeNode<Integer> binaryTree6 = new BSTreeNode<Integer>(6);
        binaryTree3.setLeft(binaryTree1);
        binaryTree3.setRight(binaryTree5);
        binaryTree5.setLeft(binaryTree4);
        binaryTree5.setRight(binaryTree6);
        binaryTree1.setRight(binaryTree2);

        BinaryTree bt = new BinaryTree();
        bt.PreorderTraversal(binaryTree3);
        System.out.println();
        bt.InorderTraversal(binaryTree3);
        System.out.println();
        bt.PostorderTraversal(binaryTree3);
    }

}
