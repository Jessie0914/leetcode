package test;

import java.util.*;

/**
 * @ClassName twoTest
 * @Description TODO
 * @Author shishi
 * @Date 2019/9/29 17:55
 **/
public class twoTest {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String line = scanner.next();
        String[] timeArray = line.split(" ");
        int[][] internals = new int[timeArray.length][2];
        for (int i=0;i<timeArray.length;i++){
            String time = timeArray[i];
            String[] timeSplit = time.split(",");
            String timeA = timeSplit[0].substring(1, timeSplit.length);
            String timeB = timeSplit[1].substring(0, timeSplit.length - 1);
            internals[i][0] = Integer.valueOf(timeA);
            internals[i][1] = Integer.valueOf(timeB);
        }

        int result = eraseOverlapIntervals(internals);

        System.out.println("count:"+result);
        for (int k=0;k<list.size();k++){
            int index = list.get(k);
            System.out.print("("+internals[index][0]+","+internals[index][1]+")");
            if (k!=list.size()-1){
                System.out.print(" ");
            }
        }
    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        // 先将这数组按照end从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 0;
        // 一直取end最小的一个
        int i=0;
        while (i<intervals.length){
            list.add(i);
            int j=i+1;
            // 只要start比i的end小就会冲突
            while (j<intervals.length&&intervals[j][0]<intervals[i][1]){
                count++;
                j++;
            }
            i = j;
        }
        return intervals.length-count;
    }
}
