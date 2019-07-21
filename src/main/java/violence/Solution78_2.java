package violence;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution78_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/16 22:11
 **/
public class Solution78_2 {
    // 迭代法
    public List<List<Integer>> subsets(int[] nums) {
        // 代码是题解里的一个代码
        // 解析可以参考https://blog.csdn.net/x603560617/article/details/87683955
        List<List<Integer>> res = new ArrayList<>();
        // 先加入空集
        res.add(new ArrayList<>());
        // 然后遍历数组，每次统一给结果集中所有的list加入当前的nums[i]
        for (int i = 0; i < nums.length; i++) {
            // 一开始all大小为1，为空集，然后给它加上nums[0]=1，结果集就变成了[]、[1]
            // 然后第二次遍历，就变成了给结果集[]、[1]统一加上nums[1]=2，就变成了[]、[1]、[2]、[1,2]
            int all = res.size();
            for (int j = 0; j < all; j++) {
                // 不能这么写，因为这样的话，list做了改动，会影响之前的结果，因为他们实际上是一个对象，最后的结果所有的list都是一样的
                // 因为他们取得是同一个地址的内容，只不过复制了很多份而已
//                List<Integer> list = result.get(j);
                // 所以需要复制当前的list到一个新对象中再操作，才不会影响之前的
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
