package Depth_search_traverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution872
 * @Description 872.叶子相似的树
 * @Author shishi
 * @Date 2019/7/27 10:20
 **/

public class Solution872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> allLeafOfTree1 = findAllLeaf(root1);
        List<Integer> allLeafOfTree2 = findAllLeaf(root2);
        // 这里我是自己比较两个list的大小
//        if (allLeafOfTree1.size()!=allLeafOfTree2.size()) return false;
//        else {
//            for (int i=0;i<allLeafOfTree1.size();i++){
//                if (allLeafOfTree1.get(i)!=allLeafOfTree2.get(i)){
//                    return false;
//                }
//            }
//            return true;
//        }

        // 也可以直接比较
        return allLeafOfTree1.equals(allLeafOfTree2);
    }

    public List<Integer> findAllLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null)
            list.add(root.val);
        list.addAll(findAllLeaf(root.left));
        list.addAll(findAllLeaf(root.right));
        return list;
    }
}
