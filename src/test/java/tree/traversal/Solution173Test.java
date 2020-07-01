package tree.traversal;

import org.junit.Test;

public class Solution173Test {
    TreeNode p = new TreeNode(7);
    TreeNode p1 = new TreeNode(3);
    TreeNode p2 = new TreeNode(15);
    TreeNode p21 = new TreeNode(9);
    TreeNode p22 = new TreeNode(20);

    @Test
    public void test() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = null;
        p22.left = p22.right = null;

        Solution173 solution173 = new Solution173(p);
        System.out.println(solution173.next());
        System.out.println(solution173.next());
        System.out.println(solution173.hasNext());
        System.out.println(solution173.next());
        System.out.println(solution173.hasNext());
        System.out.println(solution173.next());
        System.out.println(solution173.hasNext());
        System.out.println(solution173.next());
        System.out.println(solution173.hasNext());

    }

}