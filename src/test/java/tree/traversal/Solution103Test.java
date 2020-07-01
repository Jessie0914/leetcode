package tree.traversal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution103Test {
    TreeNode p = new TreeNode(3);
    TreeNode p1 = new TreeNode(9);
    TreeNode p2 = new TreeNode(20);
    TreeNode p21 = new TreeNode(15);
    TreeNode p22 = new TreeNode(7);

    @Test
    public void zigzagLevelOrder() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = null;
        p22.left = p22.right = null;

        Solution103 solution103 = new Solution103();
        List<List<Integer>> lists = solution103.zigzagLevelOrder(p);
        for (List list : lists){
            for (Object i : list){
                System.out.println(i);
            }
            System.out.println("-----------------");
        }
    }
}