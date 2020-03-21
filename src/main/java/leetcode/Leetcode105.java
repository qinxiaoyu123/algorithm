package leetcode;

import java.util.Arrays;

public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length == 1 && inorder.length == 1){
            TreeNode node = new TreeNode(preorder[0]);
            node.left = null;
            node.right = null;
            return node;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int index = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }
//        inorder[0-(i-1)]对应左子树，inorder[i+1.。。]对应右子树，
        if(1>index) node.left = null;
        else{
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, index),
                    Arrays.copyOfRange(inorder, 0, index-1));
        }
        if(index+1>preorder.length-1) node.right = null;
        else{
            node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length-1),
                    Arrays.copyOfRange(inorder, index+1, inorder.length-1));
        }
        return node;
    }
}
