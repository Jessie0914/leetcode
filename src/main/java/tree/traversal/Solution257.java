package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution257
 * @Description 257.二叉树的所有路径
 * @Author shishi
 * @Date 2019/7/25 16:27
 **/

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfsPath(root,cur,result);

        // 此时，result包含了所有的路径
        // 遍历路径List，转换成字符串即可
        List<String> strings = new ArrayList<>();
        for (List list : result){
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<list.size();i++){
                if (i!=list.size()-1){
                    sb.append(list.get(i)+"->");
                }else {
                    sb.append(list.get(i));
                }
            }
            String s = sb.toString();
            strings.add(s);
        }
        return strings;
    }

    // 递归查找所有的路径
    private void dfsPath(TreeNode root, List<Integer> cur, List<List<Integer>> result) {
        if (root==null) return;

        // 添加当前节点的值
        cur.add(root.val);
        // 如果已经到根节点了，就把当前的cur存入result
        if (root.left==null && root.right==null){
            result.add(new ArrayList<>(cur));
        }
        // 递归遍历左结点和右节点
        else {
            dfsPath(root.left,cur,result);
            dfsPath(root.right,cur,result);
        }
        // 当cur中所有的结点以及左右节点都遍历过了，就回退
        cur.remove(cur.size()-1);
    }
}
