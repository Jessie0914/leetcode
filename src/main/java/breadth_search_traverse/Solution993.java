package breadth_search_traverse;

/**
 * @ClassName Solution993
 * @Description 993.二叉树的堂兄弟结点
 * @Author shishi
 * @Date 2019/7/24 10:11
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 *如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点
 */
public class Solution993 {
    // 存放找到的两个结点以及他们的父节点
    TreeNode xNode,yNode,xParentNode,yParentNode;
    // 他们对应的层数
    int level1,level2;
    // 用队列进行层序遍历
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while (size>0){
                size--;
                TreeNode poll = queue.poll();
                // 找到了结点之后，就存放它对应的层数
                if (poll.val==x || poll.val==y){
                    if (level1==0) level1 = depth;
                    else level2 = depth;
                }

                // 为了找他们的父节点，必须从父节点就开始判断他们的子节点是不是该找的结点
                if (poll.left!=null) {
                    queue.offer(poll.left);
                    // 如果是的话，就存放当前的结点以及父节点
                    if (poll.left.val==x || poll.left.val==y){
                        if (xNode==null){
                            xNode = poll.left;
                            xParentNode = poll;
                        }else {
                            yNode = poll.left;
                            yParentNode = poll;
                        }

                    }
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    if (poll.right.val==x || poll.right.val==y){
                        if (xNode==null){
                            xNode = poll.right;
                            xParentNode = poll;
                        }else {
                            yNode = poll.right;
                            yParentNode = poll;
                        }
                    }
                }

                // 当找到了所有该找的变量，就break即可
                if (xNode!=null && yNode!=null && level1!=0 && level2!=0) break;
            }
        }
        // 如果层数不一样，就不是堂兄弟
        if (level1!=level2) return false;
        else {
            // 如果父节点一样，说明是亲兄弟，不是堂兄弟
            if (xParentNode.val==yParentNode.val) return false;
            else return true;
        }
    }
}
