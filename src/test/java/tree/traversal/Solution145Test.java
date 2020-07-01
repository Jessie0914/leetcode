package tree.traversal;

import org.junit.Test;

import java.util.List;

public class Solution145Test {
    TreeNode p = new TreeNode(7);
    TreeNode p1 = new TreeNode(3);
    TreeNode p2 = new TreeNode(15);
    TreeNode p21 = new TreeNode(9);
    TreeNode p22 = new TreeNode(20);


    @Test
    public void postorderTraversal() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = null;
        p22.left = p22.right = null;

        Solution145 solution145 = new Solution145();
        List<Integer> list = solution145.postorderTraversal(p);
        for (int i : list){
            System.out.println(i);
        }
    }

    @Test
    public void postorderTraversal2() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = null;
        p22.left = p22.right = null;

        Solution145 solution145 = new Solution145();
        List<Integer> list = solution145.postorderTraversal2(p);
        for (int i : list){
            System.out.println(i);
        }
    }
}