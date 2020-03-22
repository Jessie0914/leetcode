package top_interview;

/**
 * @ClassName Solution56
 * @Description 合并区间
 * @Author shishi
 * @Date 2020/3/9 12:03
 **/

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<Interval> list = new LinkedList<>();

        for (int[] nums : intervals){
            list.add(new Interval(nums));
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval cur : list) {
            // 没有冲突
            if (merged.isEmpty() || merged.getLast().end < cur.start)
                merged.add(cur);

            else
                merged.getLast().end = Math.max(merged.getLast().end, cur.end);
        }

        int[][] result = new int[merged.size()][2];
        int index = 0;
        for (Interval cur : merged) {
            result[index++] = new int[]{cur.start, cur.end};
        }

        return result;

    }

    class Interval {
        int start;
        int end;

        public Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }
    }
}
