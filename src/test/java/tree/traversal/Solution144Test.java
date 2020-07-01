package tree.traversal;

import org.junit.Test;

import java.util.List;

public class Solution144Test {
    TreeNode p = new TreeNode(1);
    TreeNode p2 = new TreeNode(2);
    TreeNode p21 = new TreeNode(3);
//
//    TreeNode q = new TreeNode(1);
//    TreeNode q1 = new TreeNode(2);
//    TreeNode q2 = new TreeNode(3);

    @Test
    public void preorderTraversal() {
        p.right = p2;
        p.left = null;
        p2.left = p21;
        p2.right = null;
        p21.left = p21.right = null;

        Solution144 solution144 = new Solution144();
        List<Integer> list = solution144.preorderTraversal(p);
        for (int i : list){
            System.out.println(i);
        }
    }

    @Test
    public void preorderTraversal2() {
        p.right = p2;
        p.left = null;
        p2.left = p21;
        p2.right = null;
        p21.left = p21.right = null;

        Solution144 solution144 = new Solution144();
        List<Integer> list = solution144.preorderTraversal2(p);
        for (int i : list){
            System.out.println(i);
        }
    }
}