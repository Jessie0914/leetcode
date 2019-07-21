package violence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution90_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/17 22:50
 **/
public class Solution90_2 {
    // 迭代的方法
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        result.add(pre);
        int start = 0;
        for (int i=0;i<nums.length;i++){
            int size = result.size();
            // 如果不是重复的元素，就把start指标置为0，让j从头开始遍历
            if (i>0 && nums[i]!=nums[i-1])
                start=0;
            for (int j=start;j<size;j++){
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            // 把start设置为上一此第一次添加过元素的位置
            // 如果下一个i不是重复的元素，下一步会把它置为0的
            start = result.size()-(size-start);
        }
        return result;
    }
}
