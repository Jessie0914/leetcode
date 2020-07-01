package tree.traversal;

import org.junit.Test;

import java.util.List;

public class Solution94Test {
    TreeNode p = new TreeNode(3);
    TreeNode p1 = new TreeNode(9);
    TreeNode p2 = new TreeNode(20);
    TreeNode p21 = new TreeNode(15);
    TreeNode p22 = new TreeNode(7);

    @Test
    public void inorderTraversal() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = null;
        p22.left = p22.right = null;

        Solution94 solution94 = new Solution94();
        List<Integer> list = solution94.inorderTraversal(p);
        for (int i : list){
            System.out.println(i);
        }
    }
}