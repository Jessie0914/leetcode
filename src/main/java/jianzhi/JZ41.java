package jianzhi;

import java.util.ArrayList;

/**
 * @Classname JZ41
 * @Description 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @Date 2020/7/24 2:11 下午
 * @Created by chiyue
 */
public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 2)
            return lists;

        int i = 1;
        int j = 2;
        while (i < j) {
            int tmp = (i + j) * (j - i + 1) / 2;

            if (tmp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int x = i; x <= j; x++)
                    list.add(x);
                lists.add(list);
                i++;
                j++;
            } else if (tmp > sum) {
                i++;
            } else
                j++;

        }

        return lists;
    }
}
