package leetcode;


import java.util.Arrays;

public class MaxPathSum {
    static int result = -0x3f3f3f3f;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        result = -0x3f3f3f3f;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int leftValue = 0;
        int rightValue = 0;
        if (root.left != null) {
            leftValue = dfs(root.left);
            result = Math.max(leftValue, result);
        }
        if (root.right != null) {
            rightValue = dfs(root.right);
            result = Math.max(rightValue, result);
        }
        //定义sum是因为路径不能重复，因此如果当前点要是想和上一级点连接，就只能取leftValue + root.val 或者rightValue + root.val或者root.val
        int sum = rightValue + root.val + leftValue;
        root.val = Math.max(Math.max(rightValue + root.val, root.val), leftValue + root.val);
        result = Math.max(result,sum);
        return root.val;
    }

    public static void main(String[] args) {

    }
}
