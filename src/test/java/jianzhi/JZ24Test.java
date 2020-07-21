package jianzhi;

import org.junit.Test;

import static org.junit.Assert.*;

public class JZ24Test {

    @Test
    public void findPath() {
        JZ24 jz24 = new JZ24();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.right = new TreeNode(7);
        jz24.FindPath(root,22);
    }
}