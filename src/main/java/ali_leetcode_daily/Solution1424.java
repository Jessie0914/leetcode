package ali_leetcode_daily;

import java.util.*;

/**
 * @ClassName Solution1424
 * @Description 对角线遍历2
 * @Author shishi
 * @Date 2020/6/19 22:21
 **/
public class Solution1424 {
    // https://leetcode-cn.com/problems/diagonal-traverse-ii/solution/treemapan-dui-jiao-xian-ju-he-zhi-by-zuo-zhou-ren/
    // 巧用Map
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 用来存放（对角线加起来的值，对应的list）
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i + j, list);
                }
            }
        }

        int[] result = new int[count];
        int index = 0;
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            for (int i = map.get(cur).size() - 1; i >= 0; i--) {
                result[index++] = map.get(cur).get(i);
            }
        }

        return result;
    }

    // 这种没有办法通过“第一行很长，但是最后一行很短”的那种案例
    public int[] findDiagonalOrder2(List<List<Integer>> nums) {
        int m = nums.size();
        int count = 0;
        for (List<Integer> list : nums) {
            count += list.size();
        }
        int[] res = new int[count];
        int index = 0;

        // 先遍历m行
        for (int i = 0; i < m; i++) {
            int curLine = i;
            int j = 0;
            while (curLine >= 0) {
                // 先要判断j有没有超出范围
                if (j < nums.get(curLine).size()) {
                    res[index++] = nums.get(curLine).get(j);
                }

                curLine--;
                j++;
            }
        }

        // 遍历最后一行（最后一行的第一个已经遍历过）
        for (int i = 1; i < nums.get(m - 1).size(); i++) {
            int curLine = m - 1;
            int j = i;
            while (curLine >= 0) {
                if (j < nums.get(curLine).size())
                    res[index++] = nums.get(curLine).get(j);

                curLine--;
                j++;
            }
        }

        return res;

    }

}
