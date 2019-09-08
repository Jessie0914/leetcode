package Depth_search_traverse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution872Test {

    @Test
    public void leafSimilar() {
        TreeNode p = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(1);

        TreeNode p11 = new TreeNode(6);
        TreeNode p12 = new TreeNode(2);

        TreeNode p21 = new TreeNode(9);
        TreeNode p22 = new TreeNode(8);
        TreeNode p121 = new TreeNode(7);
        TreeNode p122 = new TreeNode(4);

        p.left = p1;
        p.right = p2;
        p1.left = p11;
        p1.right = p12;
        p2.left = p21;
        p2.right = p22;
        p12.left = p121;
        p12.right = p122;

        Solution872 solution872 = new Solution872();
        List<Integer> allLeaf = solution872.findAllLeaf(p);
        for (Integer i : allLeaf){
            System.out.println(i);
        }
    }
}