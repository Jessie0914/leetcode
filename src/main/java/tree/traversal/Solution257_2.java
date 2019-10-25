package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution257_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/11 10:18
 **/

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class Solution257_2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        serach(res,cur,root);

        List<String> list = new ArrayList<>();
        // res里面是所有的路径list
        for (int i=0;i<res.size();i++){
            List<Integer> cur_route = res.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<cur_route.size();j++){
                if (j!=cur_route.size()-1)
                    sb.append(cur_route.get(j)+"->");
                else
                    sb.append(cur_route.get(j));
            }
            list.add(sb.toString());
        }
        return list;
    }

    private void serach(List<List<Integer>> res, List<Integer> cur, TreeNode root) {
        if (root==null)
            return;

        // 添加当前的值
        cur.add(root.val);

        // 如果到头了（即左右都没有孩子了，就添加线路）
        if (root.left==null && root.right==null){
            res.add(new ArrayList<>(cur));
            return;
        }


        if (root.left!=null){
            serach(res,cur,root.left);

            // 回退一步
            cur.remove(cur.size()-1);
        }

        if (root.right!=null){
            serach(res,cur,root.right);
            // 回退一步
            cur.remove(cur.size()-1);
        }
    }
}