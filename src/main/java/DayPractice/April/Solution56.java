package DayPractice.April;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @ClassName Solution56
 * @Description 合并区间
 * @Author shishi
 * @Date 2020/4/17 13:24
 **/
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        // 将区间按照开始时间来排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        LinkedList<int[]> merged = new LinkedList<>();
        int i = 0;
        // 去和merged的最后一个集合去比较
        while (i < intervals.length) {
            if (merged.size() == 0) {
                merged.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                int[] last = merged.getLast();
                // 有交叉的话
                if (last[1] >= intervals[i][0]) {
                    last[0] = Math.min(last[0], intervals[i][0]);
                    last[1] = Math.max(last[1], intervals[i][1]);
                } else {
                    merged.add(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
            i++;
        }

        // 遍历结果集合，即可
        int[][] ans = new int[merged.size()][2];
        int index = 0;
        for (int[] m : merged) {
            ans[index][0] = m[0];
            ans[index][1] = m[1];
            index++;
        }
        return ans;
    }
}
