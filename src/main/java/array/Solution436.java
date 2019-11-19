package array;

import java.util.*;

/**
 * @program: leetcode
 * @description: 436. 寻找右区间
 * @author: shishi
 * @create: 2019-11-12 15:43
 **/

/**
 * 输入: [ [1,2] ]
 * 输出: [-1]
 *
 * 输入: [ [3,4], [2,3], [1,2] ]
 * 输出: [-1, 0, 1]
 *
 * 输入: [ [1,4], [2,3], [3,4] ]
 * 输出: [-1, 2, -1]
 */
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> startMap = new HashMap<>();

        for (int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            startMap.put(interval[0],i);
        }

        // 排序
        List<Map.Entry<Integer, Integer>> startEntriesList = new ArrayList<>(startMap.entrySet());
        Collections.sort(startEntriesList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });

        int[] res = new int[intervals.length];
        for (int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            int end = interval[1];
            int j=0;
            for (;j<startEntriesList.size();j++){
                if (startEntriesList.get(j).getKey()>=end){
                    res[i] = startEntriesList.get(j).getValue();
                    break;
                }
            }
            if (j==startEntriesList.size()){
                res[i] = -1;
            }
        }
        return res;
    }

    public int[] findRightInterval2(int[][] intervals) {
        TreeMap<Integer, Integer> startMap = new TreeMap<>();

        for (int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            startMap.put(interval[0],i);
        }

        int[] res = new int[intervals.length];
        for (int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            int end = interval[1];
            Map.Entry<Integer, Integer> ceilingEntry = startMap.ceilingEntry(end);
            res[i] = ceilingEntry==null? -1 : ceilingEntry.getValue();
        }
        return res;
    }
}
