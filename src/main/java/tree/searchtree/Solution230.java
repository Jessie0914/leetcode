package tree.searchtree;

/**
 * @ClassName Solution230
 * @Description 230.二叉搜索树中第K小的元素
 * @Author shishi
 * @Date 2019/7/10 12:14
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Solution230 {
    // 这个思路很简单，就是中序遍历之后，取第K个元素即可
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = inOrder(root);
        System.out.println(inorderList.toString());
        return inorderList.get(k-1);
    }

    private List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) return list;
        list.addAll(inOrder(root.left));
        list.add(root.val);
        list.addAll(inOrder(root.right));
        return list;
    }

    // 另一种方法，非递归的方法（也是用到了中序遍历的思想，只不过当它一旦找到了k大个元素就直接退出循环了）
    // 思想：如果能够修改节点的数据结构 TreeNode ，可以增加一个字段 leftCnt ，表示左子树的节点个数。设当前节点为 root
    // 若 k == root.leftCnt+1 , 则返回root
    // 若 k > node.leftCnt , 则 k -= root.leftCnt+1 , root=root.right
    // 否则， node = node.left
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                k--;
                if (k==0) return p.val;
                p = p.right;
            }
        }
        return -1;
    }
}
