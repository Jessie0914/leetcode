package tree.searchtree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution95Test {

    @Test
    public void generateTrees() {
        Solution95 solution95 = new Solution95();
        List<TreeNode> list = solution95.generateTrees(3);
        for (TreeNode root : list){
            System.out.println(root.toString());
        }
    }
}