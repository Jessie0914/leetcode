package tree.traversal;

import org.junit.Test;

import java.util.List;

public class Solution199Test {
    TreeNode p = new TreeNode(1);
    TreeNode p1 = new TreeNode(2);
    TreeNode p2 = new TreeNode(3);
    TreeNode p12 = new TreeNode(5);
    TreeNode p22 = new TreeNode(4);

    @Test
    public void rightSideView() {
        p.left = p1;
        p.right = p2;
        p1.left = null;
        p1.right = p12;
        p2.left = null;
        p2.right = p22;
        p12.left = p12.right = null;
        p22.left = p22.right = null;

        Solution199 solution199 = new Solution199();
        List<Integer> list = solution199.rightSideView(p);
        for (Integer i : list){
            System.out.println(i);
        }
    }

}