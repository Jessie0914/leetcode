package ali_leetcode_daily.bytedance;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution958Test {

    @Test
    public void isCompleteTree() {
        Solution958 solution958 = new Solution958();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        boolean completeTree = solution958.isCompleteTree(root);
        System.out.println(completeTree);
    }
}