package jianzhi;

import org.junit.Test;

import static org.junit.Assert.*;

public class JZ17Test {

    @Test
    public void hasSubtree() {
        JZ17 jz17 = new JZ17();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(7);
        boolean b = jz17.HasSubtree(root1, root2);
        System.out.println(b);
    }
}