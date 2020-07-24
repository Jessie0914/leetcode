package ali_leetcode_daily.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Non_Recursion_TraversalTest
 * @Description 非递归遍历二叉树的测试类
 * @Date 2020/7/24 11:24 上午
 * @Created by chiyue
 */
public class Non_Recursion_TraversalTest {

    @Test
    public void traversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Non_Recursion_Traversal traversal = new Non_Recursion_Traversal();
        List<Integer> list = new ArrayList<>();
        traversal.postOrderTraversal_2(root,list);

        System.out.println(list.toString());
    }

}