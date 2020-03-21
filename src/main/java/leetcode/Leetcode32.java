package leetcode;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode32 {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left!=null) {
                queue.offer(tmp.left);
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
            }
            list.add(tmp.val);
        }

        int [] a = new int[list.size()];
        int i = 0;
        for(Integer tmp:list){
            a[i++] = tmp;
        }
        return a;
    }

}
